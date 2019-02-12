package com.weather.demo;

import com.weather.demo.controller.WeatherResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class testing {

    private MockMvc mockMvc;

    @InjectMocks
    private WeatherResource weatherResource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(weatherResource).build();
    }

    @Test
    public void testWeatherController() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/testing")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}


/*@Autowired
    private WebApplicationContext webApplicationContext;

    WeatherResource weatherResource = new WeatherResource();
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        //build mockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testGetweather() {
//        MvcResult mvcResult = mockMvc.perform(put("/some/uri/{foo}/{bar}", "foo", "bar"))
//                .andExpect(status().isOk()).andReturn();
//        WeatherDTO weather = weatherResource.getWeather("78717");
//        Assert.assertNotNull(weather);
    }*/