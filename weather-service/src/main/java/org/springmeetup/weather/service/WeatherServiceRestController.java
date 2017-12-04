package org.springmeetup.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springmeetup.weather.service.ows.WeatherServiceOWSClient;
import org.springmeetup.weather.service.ows.domain.Weather;


@RestController
public class WeatherServiceRestController {

    @Value("${app.weather.api.key}")
    private String apiKey;

    @Autowired
    WeatherServiceOWSClient weatherServiceOWSClient;
    
	@GetMapping("/weather/current/{country}/{city}")
	public Weather getWeather(@PathVariable("country") String country, @PathVariable("city") String city) {
		return weatherServiceOWSClient.getWeather(country, city);
	}
}
