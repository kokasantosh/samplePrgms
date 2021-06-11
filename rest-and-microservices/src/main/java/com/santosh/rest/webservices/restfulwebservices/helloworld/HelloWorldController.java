package com.santosh.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

//    @RequestMapping(method = RequestMethod.GET, path="hello-world")
    @GetMapping(path = "hello-world")
    public String helloWorld() {
        return "HelloWorld";
    }

    @GetMapping(path = "hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="accept-language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, "Default Message", LocaleContextHolder.getLocale());
    }

    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
