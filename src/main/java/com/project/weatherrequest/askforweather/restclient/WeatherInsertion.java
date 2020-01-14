package com.project.weatherrequest.askforweather.restclient;


import com.project.weatherrequest.askforweather.dao.WeatherDataDao;
import com.project.weatherrequest.askforweather.entity.WeatherData;
import com.project.weatherrequest.askforweather.restclient.openweathermap.OpenWeatherMapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherInsertion {

    WeatherDataDao weatherDataDao;

    @Autowired
    public WeatherInsertion(WeatherDataDao weatherDataDao) {
        this.weatherDataDao = weatherDataDao;
    }

    public WeatherInsertion() {
    }

    @Scheduled(fixedRate = 1_800_000)
    public void requesting(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Host", "api.openweathermap.org");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("q", "Chelyabinsk");
        params.put("APPID", "0ed4593211fe4ba78de5a8a963426ae2");
        String url = "https://api.openweathermap.org/data/2.5/weather?q={q}&APPID={APPID}";
        ResponseEntity<OpenWeatherMapResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, OpenWeatherMapResponse.class, params);
        WeatherData writeToDataBase = new WeatherData(
                response.getBody().getName(),
                response.getBody().getMain().getTemp(),
                response.getBody().getMain().getPressure(),
                response.getBody().getMain().getHumidity(),
                response.getBody().getVisibility(),
                response.getBody().getWind().getSpeed()
        );
        weatherDataDao.save(writeToDataBase);
    }
}
