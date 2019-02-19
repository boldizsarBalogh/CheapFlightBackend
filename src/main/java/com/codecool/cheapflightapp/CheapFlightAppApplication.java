package com.codecool.cheapflightapp;

import com.codecool.cheapflightapp.Repository.FlightRepository;
import com.codecool.cheapflightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheapFlightAppApplication {

    @Autowired
    private FlightRepository flightRepository;

    public static void main(String[] args) {
        SpringApplication.run(CheapFlightAppApplication.class, args);
    }

    @Bean
    public void uploadDatabase(){
        Flight flight1 = new Flight("Ryanair", "BUD", "MAD", "2019-03-01", "17:45", "20:20", "Turista", 99.9);
        flightRepository.save(flight1);
        Flight flight2 = new Flight("Wizzapr", "BUD", "BER", "2019-03-02", "17:45", "20:20", "Turista", 39.95);
        flightRepository.save(flight2);
        Flight flight3 = new Flight("Wizzapr", "BUD", "BER", "2019-03-02", "17:45", "20:20", "Turista", 39.95);
        flightRepository.save(flight3);
        Flight flight4 = new Flight("Wizzapr", "BUD", "BEL", "2019-03-03", "15:45", "16:55", "Turista", 19.95);
        flightRepository.save(flight4);
    }

}

