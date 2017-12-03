package org.springmeetup.weather.web;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springmeetup.weather.web.ows.domain.Weather;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port=8182)
public class WeatherWebApplicationTests {

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
		.downloadStub("org.springmeetup", "weather-service", "0.0.1-SNAPSHOT", "stubs")
		.withPort(8083)
		.workOffline(true);
	
	@Test
	public void get_weather_from_service_contract() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Weather> weatherResponseEntity = restTemplate.getForEntity("http://localhost:8083/weather/current/TR/Denizli", Weather.class);
		
		BDDAssertions.then(weatherResponseEntity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(weatherResponseEntity.getBody().getName()).isEqualTo("Denizli");
		
	}
}
