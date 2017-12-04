package org.springmeetup.weather.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister=false)
public class WeatherServiceApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}
	
}
