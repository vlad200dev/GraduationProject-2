package com.project.weatherrequest.askforweather;

import com.project.weatherrequest.askforweather.dao.WeatherDataDaoImpl;
import com.project.weatherrequest.askforweather.entity.WeatherData;
import com.project.weatherrequest.askforweather.restclient.openweathermap.OpenWeatherMapResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class AskforweatherApplication {

	public static void main(String[] args)  {
		SpringApplication.run(AskforweatherApplication.class, args);
	}

	@Bean()
	@Scope(scopeName = "prototype")
	@Scheduled(fixedRate = 60000)
	public static void getWeatherImport() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Host","api.openweathermap.org");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Map<String,String> params = new HashMap<>();
		params.put("q","Chelyabinsk");
		params.put("APPID","0ed4593211fe4ba78de5a8a963426ae2");
//        String url ="https://api.openweathermap.org/data/2.5/weather?q=Chelyabinsk&APPID=0ed4593211fe4ba78de5a8a963426ae2";
		String url ="https://api.openweathermap.org/data/2.5/weather?q={q}&APPID={APPID}";
		ResponseEntity<OpenWeatherMapResponse> response = restTemplate.exchange(url, HttpMethod.GET,entity, OpenWeatherMapResponse.class,params);
		WeatherData writeToDataBase = new WeatherData(
				response.getBody().getName(),
				response.getBody().getMain().getTemp(),
				response.getBody().getMain().getPressure(),
				response.getBody().getMain().getHumidity(),
				response.getBody().getVisibility(),
				response.getBody().getWind().getSpeed()
		);
		new WeatherDataDaoImpl().saveWeatherData(writeToDataBase);
	}
}