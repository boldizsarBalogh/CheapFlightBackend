package com.codecool.cheapflightapp;

import com.codecool.cheapflightapp.Repository.FlightRepository;
import com.codecool.cheapflightapp.Service.DataBaseInitializer;
import com.codecool.cheapflightapp.model.Flight;
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

    public static void main(String[] args) {
        SpringApplication.run(CheapFlightAppApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {
            dataBaseInitializer.initalize(flightRepository,2000);
        };
    }

}

