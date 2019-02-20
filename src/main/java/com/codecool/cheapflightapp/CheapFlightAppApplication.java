package com.codecool.cheapflightapp;

import com.codecool.cheapflightapp.repository.CityRepository;
import com.codecool.cheapflightapp.repository.FlightRepository;
import com.codecool.cheapflightapp.Service.DataBaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
public class CheapFlightAppApplication {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private DataBaseInitializer dataBaseInitializer;

    @Autowired
    private CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(CheapFlightAppApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {
            String[] cityArr =  {"Budapest","Berlin","Madrid","Paris","Brussels"};
            dataBaseInitializer.initializeCities(cityArr,cityRepository);
            dataBaseInitializer.initalizeFlights(flightRepository,2000,cityRepository.findAll());
        };
    }

}

