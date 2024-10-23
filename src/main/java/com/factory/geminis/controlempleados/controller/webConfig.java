package com.factory.geminis.controlempleados.controller;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        var slr=new SessionLocaleResolver();//i18n de internacionalition
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        //parametro para cambiar de lenguaje
        var lci= new LocaleChangeInterceptor();
        //cuando se adjunte lang en la url se especifica el idioma
        lci.setParamName("lang");
        return lci; 
    }
    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    @Override
    public void addViewControllers(@SuppressWarnings("null") ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login");
        registry.addViewController("/errores/403").setViewName("/errores/403");
    }
}
