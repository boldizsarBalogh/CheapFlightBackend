package com.codecool.cheapflightapp;

//import com.codecool.cheapflightapp.Service.FlightCreator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import javax.annotation.PostConstruct;

@SpringBootApplication
public class CheapFlightAppApplication {

//    private static final Logger LOGGER = LoggerFactory.getLogger(CheapFlightAppApplication.class);

//    @Autowired
//    private FlightCreator flightCreator;

    public static void main(String[] args) {
        SpringApplication.run(CheapFlightAppApplication.class, args);
    }

//    @PostConstruct
//    public void afterInit(){
//        LOGGER.info(flightCreator.createFlight().toString());
//    }

}

