package com.project.weatherrequest.askforweather.service;

import com.project.weatherrequest.askforweather.dao.WeatherDataDao;
import com.project.weatherrequest.askforweather.entity.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private WeatherDataDao weatherDataDao;

    @Autowired
    public WeatherDataServiceImpl(WeatherDataDao weatherDataDao) {
        this.weatherDataDao = weatherDataDao;
    }


    @Override
    @Transactional
    public List<WeatherData> getInformation() {
        return weatherDataDao.getInformation();
    }

    @Override
    @Transactional
    public WeatherData findById(int theId) {
        return weatherDataDao.findById(theId);
    }
}
