package com.github.asaas.pebble.spring.translate.conf;

import org.springframework.context.annotation.Bean;

import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;

public class TemplateLoaderTestConfig {

    @Bean
    public Loader templateLoader() {
        ClasspathLoader templateLoader = new ClasspathLoader();
        templateLoader.setPrefix("templates/");
        templateLoader.setSuffix(".peb");
        return templateLoader;
    }

}
