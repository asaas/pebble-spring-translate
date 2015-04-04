pebble-spring-translate
=======================

Translation extension for Pebble template engine, which use Spring messages interface

# Overview

Provide the `t` function for [Pebble](http://www.mitchellbosecke.com/pebble) template engine, which retrive message from Spring MessageSource.
```HTML+Django
{{ t('users.show.title') }}
```

## "Lazy" Lookup
Function support ["layzy" lookup](http://guides.rubyonrails.org/i18n.html#lazy-lookup), so you can look up `users.show.title` message inside `users/show.html` like:
```HTML+Django
{{ t('.title') }}
```

## "Lazy" Lookup without template name
You can look up `users.my_message` message inside `users/show.html` like:
```HTML+Django
{{ t('..my_message') }}
```

## Arguments:
```HTML+Django
{{ t('.title', 'arg1', 'arg2', 'arg3') }}
```

# Setup

You need add extension to Pabble engine and provide Spring MessageSource:
```java

@Autowired
private ServletContext context;

@Bean  
public MessageSource messageSource() {  
    ResourceBundleMessageSource ms = new ResourceBundleMessageSource();  
    ms.setBasename("i18n/messages");
    return ms;  
}  

@Bean
public PebbleEngine pebbleEngine() {
    PebbleEngine pe = new PebbleEngine(new ServletLoader(context));
    pe.addExtension(new TranslateExtension(messageSource()));
    return pe;
}
```
