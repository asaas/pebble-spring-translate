package com.asaas.pebble.spring.translate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.MessageSource;

import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Function;

/**
 * Extension which provide 't' function
 * 
 * @author UshakovVasilii
 *
 */
public class TranslateExtension extends AbstractExtension {

    private final MessageSource messageSource;

    /**
     * Create a new TranslateExtension that provide 't' function
     * 
     * @param messageSource
     *            the MessageSource which is used to resolve messages
     */
    public TranslateExtension(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Provide 't' function, which use message source
     */
    @Override
    public Map<String, Function> getFunctions() {
        Map<String, Function> functions = new HashMap<>();
        functions.put("t", new TranslateFunction(messageSource));
        return functions;
    }

}