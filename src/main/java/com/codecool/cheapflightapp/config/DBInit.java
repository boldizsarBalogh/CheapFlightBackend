package com.codecool.cheapflightapp.config;

import com.codecool.cheapflightapp.Service.DataBaseInitializer;
import com.codecool.cheapflightapp.repository.CityRepository;
import com.codecool.cheapflightapp.repository.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class DBInit {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private DataBaseInitializer dataBaseInitializer;

    @Autowired
    private CityRepository cityRepository;

    @Bean
 //   @Profile("production")
    public CommandLineRunner init(){
        return args -> {
            String[] cityArr =  {"Budapest","Berlin","Madrid","Paris","Brussels"};
            dataBaseInitializer.initializeCities(cityArr,cityRepository);
//            dataBaseInitializer.initalizeFlights(flightRepository,2000,cityRepository.findAll());
        };
    }
}