package com.weather.demo.serviceImpl;

import com.weather.demo.client.WeatherClient;
import com.weather.demo.dto.WeatherDTO;
import com.weather.demo.model.Weather;
import com.weather.demo.model.WeatherParams;
import com.weather.demo.service.Constants;
import com.weather.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service(value = "test")
public class WeatherServiceImpl implements WeatherService {


    @Autowired
    WeatherClient weatherClient;

    @Autowired
    Constants constants;


    private static final Logger LOGGER = Logger.getLogger(WeatherServiceImpl.class.getName());


    public WeatherDTO getWeather( String zip){
        String key = zip+"-"+LocalDate.now();
        try{
            if (constants.getStringWeatherConcurrentHashMap().containsKey(key)){

                LOGGER.log(Level.INFO,"Getting from cache");
                return new WeatherDTO(constants.getStringWeatherConcurrentHashMap().get(key));
            }else {
                Weather weather = weatherClient.getWeather(zip);
                getMinTemp(weather);
                constants.getStringWeatherConcurrentHashMap().put(key,weather);
                LOGGER.log(Level.INFO,"Getting from rest");
                return new WeatherDTO(weather);
            }
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE,ex.toString());
        }
        return null;
    }

    public void getMinTemp (Weather weather) {
        List<WeatherParams> list = weather.getList();
        WeatherParams temp = list.get(0);

        for (WeatherParams w : list) {
            if(Float.parseFloat(w.getMain().getTemp_min()) < Float.parseFloat(temp.getMain().getTemp_min())) {
                temp = w;
            }
        }

        weather.setMinTemp(temp);
    }

}
