package com.rgonzalez.test.web.app;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public LocaleResolver localeResolver() {
		var slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("es"));
		return slr;
		
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		var lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registro) {
		registro.addInterceptor(localeChangeInterceptor());
	}

}
