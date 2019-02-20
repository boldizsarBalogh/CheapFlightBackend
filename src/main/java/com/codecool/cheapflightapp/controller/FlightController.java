package com.codecool.cheapflightapp.controller;


import com.codecool.cheapflightapp.Service.FlightService;
import com.codecool.cheapflightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public List<Flight> flightList(){
        return flightService.addFlightToFlights();
    }



}
