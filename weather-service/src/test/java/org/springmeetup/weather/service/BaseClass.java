package org.springmeetup.weather.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springmeetup.weather.service.ows.WeatherServiceOWSClient;
import org.springmeetup.weather.service.ows.domain.Weather;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherServiceApplicationTest.class)
public class BaseClass {

    @Autowired
    WeatherServiceRestController weatherServiceRestController;
	
    @MockBean
    WeatherServiceOWSClient weatherServiceOWSClient;
    
    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(weatherServiceRestController);
        
        Weather weatherDenizli = new Weather();
        weatherDenizli.setTemperature(39.15);
        weatherDenizli.setName("Denizli");
        weatherDenizli.setWeatherId(800);
        weatherDenizli.setWeatherIcon("01d");
        weatherDenizli.setTimestamp(1505824065);
        Mockito.when(weatherServiceOWSClient.getWeather("TR", "Denizli")).thenReturn(weatherDenizli);

        Weather weatherAnkara = new Weather();
        weatherAnkara.setTemperature(38.15);
        weatherAnkara.setName("Ankara");
        weatherAnkara.setWeatherId(802);
        weatherAnkara.setWeatherIcon("03d");
        weatherAnkara.setTimestamp(1505824065);
        Mockito.when(weatherServiceOWSClient.getWeather("TR", "Ankara")).thenReturn(weatherAnkara);
        
    }
    
}
