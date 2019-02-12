package com.weather.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProdConfig {

    @Value("${api-key}")
    public String apiKey;

    @Value("${api-url}")
    public String apiUrl;



}
