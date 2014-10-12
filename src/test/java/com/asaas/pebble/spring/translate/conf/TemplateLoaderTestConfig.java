package com.asaas.pebble.spring.translate.conf;

import org.springframework.context.annotation.Bean;

import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring.PebbleTemplateLoader;

public class TemplateLoaderTestConfig {

    @Bean
    public Loader templateLoader() {
        PebbleTemplateLoader templateLoader = new PebbleTemplateLoader();
        templateLoader.setPrefix("templates/");
        templateLoader.setSuffix(".peb");
        return templateLoader;
    }

}
