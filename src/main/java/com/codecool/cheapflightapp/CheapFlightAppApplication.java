package com.codecool.cheapflightapp;

import com.codecool.cheapflightapp.Repository.FlightRepository;
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

    public static void main(String[] args) {
        SpringApplication.run(CheapFlightAppApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {
            Flight flight1 = Flight.builder()
                    .company("Ryanair")
                    .startTown("BUD")
                    .arriveTown("MAD")
                    .date("2019-03-01")
                    .startTime("17:45")
                    .arriveTime("20:20")
                    .confort("Turista")
                    .price(99.9)
                    .build();
            flightRepository.save(flight1);

            Flight flight2 = Flight.builder()
                    .company("Wizzair")
                    .startTown("BUD")
                    .arriveTown("BER")
                    .date("2019-03-02")
                    .startTime("17:45")
                    .arriveTime("20:20")
                    .confort("Turista")
                    .price(39.95)
                    .build();
            flightRepository.save(flight2);

            Flight flight3 = Flight.builder()
                    .company("Wizzair")
                    .startTown("BUD")
                    .arriveTown("BEL")
                    .date("2019-03-03")
                    .startTime("15:45")
                    .arriveTime("16:55")
                    .confort("Turista")
                    .price(19.95)
                    .build();
            flightRepository.save(flight3);
        };
    }

}

