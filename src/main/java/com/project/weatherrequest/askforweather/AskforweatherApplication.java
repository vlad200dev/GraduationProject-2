package com.project.weatherrequest.askforweather;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class AskforweatherApplication  {

	public static void main(String[] args)  {
		SpringApplication.run(AskforweatherApplication.class, args);
	}

}
