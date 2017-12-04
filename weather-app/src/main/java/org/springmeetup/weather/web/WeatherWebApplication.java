package org.springmeetup.weather.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherWebApplication.class, args);
	}
}
