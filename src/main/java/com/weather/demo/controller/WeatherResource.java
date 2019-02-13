package com.weather.demo.controller;

import com.weather.demo.client.WeatherClient;
import com.weather.demo.dto.WeatherDTO;
import com.weather.demo.service.Constants;
import com.weather.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherResource {

    @Autowired
    WeatherClient weatherClient;

    @Autowired
    @Qualifier("test")
    WeatherService weatherService;

    @Autowired
    Constants constants;

    @RequestMapping(value = "/getWeather/{zipCode}", method = RequestMethod.GET)
    public WeatherDTO getWeather(@PathVariable String zipCode) {
        return weatherService.getWeather(zipCode);
    }

    @RequestMapping("/testing")
    public String testMethod () {
        return "hello";
    }
    
}
