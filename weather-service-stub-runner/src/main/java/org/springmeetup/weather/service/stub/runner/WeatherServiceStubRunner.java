package org.springmeetup.weather.service.stub.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;

@SpringBootApplication
@EnableStubRunnerServer
public class WeatherServiceStubRunner {

    public static void main( String[] args ) {
    		SpringApplication.run(WeatherServiceStubRunner.class, args);
    }
    
}
