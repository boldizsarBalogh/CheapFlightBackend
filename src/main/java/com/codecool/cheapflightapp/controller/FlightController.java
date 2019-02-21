package com.codecool.cheapflightapp.controller;


import com.codecool.cheapflightapp.Service.FlightService;
import com.codecool.cheapflightapp.model.Flight;
import com.codecool.cheapflightapp.model.ResultDto;
import com.codecool.cheapflightapp.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/")
    public List<Flight> flightList(){
        return flightService.addFlightToFlights();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<ResultDto> getFlights(@RequestParam Map<String, String> searchQuery) {
        String startTown= searchQuery.get("startTown");
        String arriveTown= searchQuery.get("arriveTown");
        return flightRepository.findFlightByStartTownAndArriveTown(startTown, arriveTown);

        }

}
