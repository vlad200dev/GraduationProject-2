package com.project.weatherrequest.askforweather.dao;

import com.project.weatherrequest.askforweather.entity.WeatherData;

import java.util.List;

public interface WeatherDataDao {
     List<WeatherData> getInformation();
     WeatherData findById(int theId);
}
