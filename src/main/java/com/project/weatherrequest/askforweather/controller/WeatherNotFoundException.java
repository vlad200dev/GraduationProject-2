package com.project.weatherrequest.askforweather.controller;

public class WeatherNotFoundException extends RuntimeException {

    public WeatherNotFoundException() {
    }

    public WeatherNotFoundException(String message) {
        super(message);
    }

}
