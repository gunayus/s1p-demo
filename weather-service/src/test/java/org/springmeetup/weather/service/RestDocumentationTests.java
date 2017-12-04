package org.springmeetup.weather.service;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springmeetup.weather.service.ows.WeatherServiceOWSClient;
import org.springmeetup.weather.service.ows.domain.Weather;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherServiceApplicationTest.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets", uriPort=8080)
@AutoConfigureMockMvc
public class RestDocumentationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WeatherServiceOWSClient weatherServiceOWSClient;
    
	private FieldDescriptor temperature = fieldWithPath("temperature").description("Temperature");
	private FieldDescriptor weatherId = fieldWithPath("weatherId").description("Weather Id");
	private FieldDescriptor weatherIcon = fieldWithPath("weatherIcon").description("Weather Icon code");
	private FieldDescriptor name = fieldWithPath("name").description("City name");
	private FieldDescriptor timestamp = fieldWithPath("timestamp").description("Current time at the city");


    @Before
    public void setup() {
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

    @Test
    public void get_weather_info() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/current/TR/Denizli"))
                .andExpect(status().isOk())
                .andDo(MockMvcRestDocumentation.document("get_weather_info", PayloadDocumentation.responseFields(temperature, weatherId, weatherIcon, name, timestamp)));
    }
}
