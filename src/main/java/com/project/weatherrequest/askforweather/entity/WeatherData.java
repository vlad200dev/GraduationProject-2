package com.project.weatherrequest.askforweather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("temp")
    @Column(name = "temp")
    private double temp;

    @JsonProperty("pressure")
    @Column(name = "pressure")
    private int pressure;

    @JsonProperty("humidity")
    @Column(name = "humidity")
    private int humidity;

    @JsonProperty("visibility")
    @Column(name = "visibility")
    private int visibility;

    @JsonProperty("speed")
    @Column(name = "speed")
    private int speed;


    public WeatherData(String name, Double temp, int pressure, int humidity, int visibility, int speed) {
        this.name = name;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.speed = speed;
    }

    public WeatherData() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", visibility=" + visibility +
                ", speed=" + speed +
                '}';
    }
}
