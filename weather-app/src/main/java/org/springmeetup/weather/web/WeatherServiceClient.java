package org.springmeetup.weather.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import org.springmeetup.weather.web.ows.domain.Weather;

@Service
public class WeatherServiceClient {

	@Value("${app.weather.service.url}")
	private String weatherUrl;
	
	private final RestTemplate restTemplate;
	
	public WeatherServiceClient(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}
	
	public Weather getWeather(String country, String city) {
		URI url = new UriTemplate(weatherUrl).expand(city, country);
		return invoke(url, Weather.class);
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url)
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate
				.exchange(request, responseType);
		return exchange.getBody();
	}
	
}
