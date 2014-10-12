package com.asaas.pebble.spring.translate.conf;

import org.springframework.context.annotation.Bean;

import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.loader.StringLoader;

public class StringLoaderTestConfig {

    @Bean
    public Loader templateLoader() {
        return new StringLoader();
    }

}
