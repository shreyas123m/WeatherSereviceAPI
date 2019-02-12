package com.weather.demo.service;

import com.weather.demo.dto.WeatherDTO;
import com.weather.demo.model.Weather;

public interface WeatherService {
    public WeatherDTO getWeather(String zip);
    public void getMinTemp (Weather weather);
}
