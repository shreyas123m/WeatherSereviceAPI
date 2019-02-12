package com.weather.demo.controller;

import com.weather.demo.client.WeatherClient;
import com.weather.demo.dto.WeatherDTO;
import com.weather.demo.service.Constants;
import com.weather.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/getWeather/{zipCode}")
    public WeatherDTO getWeather(@PathVariable String zipCode) {
        return weatherService.getWeather(zipCode);
    }

    @RequestMapping("/testing")
    public String testMethod () {
        return "hello";
    }

    /*@RequestMapping("/getWeather")
    public Weather testing() {

        Main main = new Main();
        main.setHumidity("220.00");
        main.setPressure("220.00");
        main.setTemp_max("220.00");
        main.setTemp_min("220.00");

        Weather weather = new Weather();
//        weather.setMain(main);

        return weather;
    }*/
}
