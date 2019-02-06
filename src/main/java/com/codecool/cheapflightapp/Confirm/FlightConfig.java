package com.codecool.cheapflightapp.Confirm;

import com.codecool.cheapflightapp.Service.FlightCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlightConfig {

    @Bean
    public FlightCreator flightCreator1(){
        return new FlightCreator();
    }

}
