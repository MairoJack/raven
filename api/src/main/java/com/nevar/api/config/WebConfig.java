package com.nevar.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");

    }

    @Bean
    HttpPutFormContentFilter httpPutFormContentFilter(){
        return new HttpPutFormContentFilter();
    }
}
