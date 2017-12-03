package org.springmeetup.weather.web.ows;

import org.springframework.stereotype.Service;
import org.springmeetup.weather.web.ows.domain.Weather;

@Service
public class WeatherServiceOWSClient {

	public Weather getWeather(String country, String city) {
		Weather weather = new Weather();
		weather.setName("Denizli");
		weather.setTemperature(30);
		
		return weather;
	}
	

	/*
    private static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";

    private static final String FORECAST_URL =
            "http://api.openweathermap.org/data/2.5/forecast?q={city},{country}&APPID={key}";

    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceOWSClient.class);

    private final RestTemplate restTemplate;

    @Value("${app.weather.api.key}")
    private String apiKey;

    public WeatherServiceOWSClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Weather getWeather(String country, String city) {
        logger.info("Requesting current weather for {}/{}", country, city);
        URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
        return invoke(url, Weather.class);
    }

    public WeatherForecast getWeatherForecast(String country, String city) {
        logger.info("Requesting weather forecast for {}/{}", country, city);
        URI url = new UriTemplate(FORECAST_URL).expand(city, country, this.apiKey);
        return invoke(url, WeatherForecast.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate
                .exchange(request, responseType);
        return exchange.getBody();
    }

	 */
}
