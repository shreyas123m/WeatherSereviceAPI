package com.weather.demo.dto;

import com.weather.demo.model.Weather;

public class WeatherDTO {
    private String date;
    private String minTemperature;

    public WeatherDTO (Weather weather) {
        this.date = weather.getMinTemp().getDt();
        this.minTemperature = weather.getMinTemp().getMain().getTemp_min();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

}
