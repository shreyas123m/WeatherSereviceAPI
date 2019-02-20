package com.weather.demo.client;


import com.weather.demo.model.Weather;
import com.weather.demo.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherClient {

    @Autowired
    Constants constants;


    public Weather getWeather(String zip){
        RestTemplate restTemplate = new RestTemplate();
        Weather response = restTemplate.getForObject(constants.getApiUrl() +zip+",us&appid="+constants.getApiKey()+"", Weather.class);
        return response;
    }

}
