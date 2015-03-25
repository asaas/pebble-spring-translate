pebble-spring-translate
=======================

Translation extension for Pebble template engine, which use Spring messages interface

# Overview

Provide the `t` function for [Pebble](http://www.mitchellbosecke.com/pebble) template engine, which retrive message from Spring MessageSource.
```HTML+Django
{{ t('users.show.title') }}
```
Function support ["layzy" lookup](http://guides.rubyonrails.org/i18n.html#lazy-lookup), so you can look up message inside `users/show.html` like:
```jinja
{{ t('.title') }}
```
Example with arguments:
```jinja
{{ t('.title', 'arg1', 'arg2', 'arg3') }}
```

# Setup

You need add extension to Pabble engine and provide Spring MessageSource:
```java
@Bean  
public MessageSource messageSource() {  
    ResourceBundleMessageSource ms = new ResourceBundleMessageSource();  
    ms.setBasename("i18n/messages");
    return ms;  
}  

@Bean
public Loader templateLoader() {
    return new PebbleTemplateLoader();
}

@Bean
public PebbleEngine pebbleEngine() {
    PebbleEngine pe = new PebbleEngine(templateLoader());
    pe.addExtension(new TranslateExtension(messageSource()));
    return pe;
}
```
