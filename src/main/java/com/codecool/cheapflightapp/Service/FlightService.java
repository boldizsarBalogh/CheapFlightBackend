package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.repository.FlightRepository;
import com.codecool.cheapflightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> addFlightToFlights(){
        return flightRepository.findAll();
    }

}
