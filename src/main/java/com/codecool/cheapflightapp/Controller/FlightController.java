package com.codecool.cheapflightapp.Controller;


import com.codecool.cheapflightapp.Service.DataBaseInitializer;
import com.codecool.cheapflightapp.Service.FlightService;
import com.codecool.cheapflightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private DataBaseInitializer dataBaseInitializer;

    @GetMapping("/")
    public List<Flight> flightList(){
        return flightService.addFlightToFlights();
    }

    @GetMapping("/cities")
    public List<String> sendCities() {
       return Arrays.asList(dataBaseInitializer.getCities());

    }

}
