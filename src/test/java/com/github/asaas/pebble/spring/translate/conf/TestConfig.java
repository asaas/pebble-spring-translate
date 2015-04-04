package com.github.asaas.pebble.spring.translate.conf;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.github.asaas.pebble.spring.translate.TranslateExtension;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.Loader;

public class TestConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setFallbackToSystemLocale(false);
        ms.setBasename("i18n/messages");
        return ms;
    }

    @Bean
    @Autowired
    public PebbleEngine pebbleEngine(Loader templateLoader) {
        PebbleEngine pe = new PebbleEngine(templateLoader);
        pe.setDefaultLocale(Locale.JAPANESE);
        pe.addExtension(new TranslateExtension(messageSource()));
        return pe;
    }

}
