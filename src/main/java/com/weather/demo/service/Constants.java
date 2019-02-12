package com.weather.demo.service;

import com.weather.demo.configuration.ProdConfig;
import com.weather.demo.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class Constants {

    @Autowired
    ProdConfig prodConfig;

    private ConcurrentHashMap<String, Weather> stringWeatherConcurrentHashMap = new ConcurrentHashMap<>();

    public String getApiKey(){
        return prodConfig.apiKey;
    }
    public String getApiUrl(){
        return prodConfig.apiUrl;
    }

    public ConcurrentHashMap<String, Weather> getStringWeatherConcurrentHashMap() {
        return stringWeatherConcurrentHashMap;
    }

    public void setStringWeatherConcurrentHashMap(ConcurrentHashMap<String, Weather> stringWeatherConcurrentHashMap) {
        this.stringWeatherConcurrentHashMap = stringWeatherConcurrentHashMap;
    }
}
