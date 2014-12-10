package com.asaas.pebble.spring.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.asaas.pebble.spring.translate.conf.TestConfig;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

@ContextConfiguration(classes = TestConfig.class)
// override listeners to ignore ServletTestExecutionListener
@TestExecutionListeners(inheritListeners = false, value = { DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class })
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected PebbleEngine pebbleEngine;

    protected String loadTemplate(String templateBody, Locale locale) {
        try {
            PebbleTemplate template = pebbleEngine.getTemplate(templateBody);

            Writer writer = new StringWriter();
            if (locale == null) {
                template.evaluate(writer);
            } else {
                template.evaluate(writer, locale);
            }
            return writer.toString();
        } catch (PebbleException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected String loadTemplate(String templateBody) {
        return loadTemplate(templateBody, null);
    }

}
