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


    public static void main(String[] args) {
        SpringApplication.run(CheapFlightAppApplication.class, args);
    }


}

