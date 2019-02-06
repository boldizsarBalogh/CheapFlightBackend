package com.codecool.cheapflightapp.Controller;


import com.codecool.cheapflightapp.Service.FlightList;
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
    private FlightList flightList;

    @GetMapping("/")
    public List<Flight> flightList(){
        flightList.addFlightToFlights();
        return flightList.getFlights();
    }

}
