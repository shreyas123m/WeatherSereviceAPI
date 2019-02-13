package com.weather.demo;

import com.weather.demo.controller.WeatherResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class testing {

    private MockMvc mockMvc;

    @Autowired
    private WeatherResource weatherResource;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(weatherResource).build();
    }

    @Test
    public void testWeatherController() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/getWeather/{zipCode}", 76051)).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/getWeather/{zipCode}", 76051).accept(MediaType.APPLICATION_JSON));
    }
}
