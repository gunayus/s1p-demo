package org.springmeetup.weather.service.ows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springmeetup.weather.service.ows.domain.Weather;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceOWSClientTest {

	private WeatherServiceOWSClient weatherServiceOWSClient;
	
	@Mock
	RestTemplateBuilder restTemplateBuilder;
	
	@Mock
	RestTemplate restTemplate;
	
	@Before
	public void setup() {
		when(restTemplateBuilder.build()).thenReturn(restTemplate);

		weatherServiceOWSClient = new WeatherServiceOWSClient(restTemplateBuilder);
		
	}
	
	@Test
	public void get_weather_info_for_denizli() {
		Weather weather = new Weather();
		weather.setName("Denizli");
		weather.setTemperature(30);
		weather.setWeatherId(800);
		weather.setWeatherIcon("03d");
		
		when(restTemplate.exchange(any(), eq(Weather.class))).thenReturn(new ResponseEntity<Weather>(weather, HttpStatus.OK));
		
		Weather weatherServiceBean = weatherServiceOWSClient.getWeather("country", "city");
		
		assertNotNull(weatherServiceBean);
		assertEquals("Denizli", weatherServiceBean.getName());
		assertEquals(30, weatherServiceBean.getTemperature(), 0);
		assertEquals(800, weatherServiceBean.getWeatherId().intValue());
		assertEquals("03d", weatherServiceBean.getWeatherIcon());
		
	}

	@Test
	public void get_weather_info_for_ankara() {
		Weather weather = new Weather();
		weather.setName("Ankara");
		weather.setTemperature(30);
		weather.setWeatherId(800);
		weather.setWeatherIcon("03d");
		
		when(restTemplate.exchange(any(), eq(Weather.class))).thenReturn(new ResponseEntity<Weather>(weather, HttpStatus.OK));
		
		Weather weatherServiceBean = weatherServiceOWSClient.getWeather("country", "city");
		
		assertNotNull(weatherServiceBean);
		assertEquals("Ankara", weatherServiceBean.getName());
		assertEquals(30, weatherServiceBean.getTemperature(), 0);
		assertEquals(800, weatherServiceBean.getWeatherId().intValue());
		assertEquals("03d", weatherServiceBean.getWeatherIcon());
		
	}
}
