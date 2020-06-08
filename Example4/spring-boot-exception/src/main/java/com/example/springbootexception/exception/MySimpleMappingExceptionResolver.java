package com.example.springbootexception.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class MySimpleMappingExceptionResolver {
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mapping = new Properties();
        mapping.setProperty("java.lang.ArithmeticException", "mathError"); //key=exception full name. value, view name
        mapping.setProperty("java.lang.NullPointerException", "nullPointerError");
        resolver.setExceptionMappings(mapping);
        return resolver;
    }
}