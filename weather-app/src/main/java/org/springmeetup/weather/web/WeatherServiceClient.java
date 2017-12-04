package org.springmeetup.weather.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springmeetup.weather.web.ows.domain.Weather;

@FeignClient("weather-service")
public interface WeatherServiceClient {

	@GetMapping("/weather/current/{country}/{city}")
	public Weather getWeather(@PathVariable("country") String country, @PathVariable("city") String city);
	
}
