package org.springmeetup.weather.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmeetup.weather.web.ows.domain.Weather;

@Controller
@RequestMapping("/")
public class WeatherSummaryController {

	@Autowired
	WeatherServiceClient weatherServiceClient;

	private List<String> locations = Arrays.asList("Peru/Lima", "US/Las Vegas", "TR/Ankara");

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView conferenceWeather() {
		Map<String, Object> model = new LinkedHashMap<>();
		model.put("summary", getSummary());
		return new ModelAndView("summary", model);
	}

	private Object getSummary() {
		List<WeatherSummary> summary = new ArrayList<>();
		for (String location : locations) {
			String country = location.split("/")[0];
			String city = location.split("/")[1];
			Weather weather = this.weatherServiceClient.getWeather(country, city);
			summary.add(createWeatherSummary(country, city, weather));
		}
		return summary;
	}



	private WeatherSummary createWeatherSummary(String country, String city,
			Weather weather) {
		// cough cough
		if ("Las Vegas".equals(city)) {
			weather.setWeatherId(666);
		}
		return new WeatherSummary(country, city, weather);
	}

}
