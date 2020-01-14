package com.project.weatherrequest.askforweather.controller;

import com.project.weatherrequest.askforweather.entity.WeatherData;
import com.project.weatherrequest.askforweather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Chelyabinsk")
public class WeatherController {

    private WeatherDataService weatherDataService;

    @Autowired
    public WeatherController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping("/all")
    public List<WeatherData> findAll() {
        return weatherDataService.getInformation();
    }

    @GetMapping("/{weatherId}")
    public WeatherData getLegacyData(@PathVariable int weatherId) {
        WeatherData weatherData = weatherDataService.findById(weatherId);

        if (weatherData == null || (weatherId > findAll().size()) || (weatherId < 0)) {
            throw new WeatherNotFoundException("Данного прогноза нет в базе данных");
        }
        return weatherData;
    }
}
