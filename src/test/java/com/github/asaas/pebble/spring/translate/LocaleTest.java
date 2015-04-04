package com.github.asaas.pebble.spring.translate;

import static org.testng.Assert.assertEquals;

import java.util.Locale;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import com.github.asaas.pebble.spring.translate.conf.StringLoaderTestConfig;

@Test
@ContextConfiguration(classes = StringLoaderTestConfig.class)
public class LocaleTest extends AbstractTest {

    public void testEn() {
        String output = loadTemplate("{{ t('message') }}", Locale.ENGLISH);
        assertEquals(output, "MsgEn");
    }

    public void testJa() {
        String output = loadTemplate("{{ t('message') }}", Locale.JAPANESE);
        assertEquals(output, "MsgJa");
    }

    public void testDefault() {
        String output = loadTemplate("{{ t('message') }}");
        assertEquals(output, "MsgJa");
    }

}
