package com.project.weatherrequest.askforweather.service;

import com.project.weatherrequest.askforweather.entity.WeatherData;

import java.util.List;

public interface WeatherDataService {
    List<WeatherData> getInformation();
    WeatherData findById(int theId);
}
