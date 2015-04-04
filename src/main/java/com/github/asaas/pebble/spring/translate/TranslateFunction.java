package com.github.asaas.pebble.spring.translate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.util.Assert;

import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.template.EvaluationContext;
import com.mitchellbosecke.pebble.template.PebbleTemplateImpl;

/**
 * Represent 't' function which resove messages with arguments. <br>
 * Function can be used to get 'lazy' lookup message, like t(".msg") this
 * expression will use
 * 
 * <pre>
 * ${templateName splitted by point}.msg
 * </pre>
 * 
 * property
 * 
 * @author UshakovVasilii
 *
 */
public class TranslateFunction implements Function {

    private final MessageSource messageSource;

    /**
     * Create a new TranslateFunction that translate messages
     * 
     * @param messageSource
     *            the MessageSource which is used in 't' function
     */
    public TranslateFunction(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Return null, 't' function has no name arguments
     */
    @Override
    public List<String> getArgumentNames() {
        return null;
    }

    /**
     * Calls to resolve message with arguments
     */
    @Override
    public Object execute(Map<String, Object> args) {
        EvaluationContext context = (EvaluationContext) args.get("_context");

        String key = null;
        List<Object> messageArgs = new ArrayList<>();

        for (int i = 0;; i++) {
            Object arg = args.get(String.valueOf(i));
            if (arg == null)
                break;
            if (i == 0)
                key = arg.toString();
            else
                messageArgs.add(arg);
        }

        Assert.notNull(key, "Message key is required");

        if (key.charAt(0) == '.') {
            String path = ((PebbleTemplateImpl) args.get("_self")).getName();
            String baseKey = path.replaceAll("/_|/", ".");
            if (key.length() > 2 && key.charAt(1) == '.') {
                key = baseKey.replaceAll("\\.[^.]+$", "") + key.substring(1);
            } else {
                key = baseKey + key;
            }
        }

        return messageSource.getMessage(key, messageArgs.toArray(),
                context.getLocale());
    }

}