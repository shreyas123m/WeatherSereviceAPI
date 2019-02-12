package com.weather.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Weather {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<WeatherParams> list;

    private WeatherParams minTemp;

    public WeatherParams getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(WeatherParams minTemp) {
        this.minTemp = minTemp;
    }

    public List<WeatherParams> getList() {
        return list;
    }

    public void setList(List<WeatherParams> list) {
        this.list = list;
    }

}
