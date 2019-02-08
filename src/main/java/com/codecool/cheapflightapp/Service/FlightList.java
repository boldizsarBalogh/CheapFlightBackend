package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.DB.FlightsDB;
import com.codecool.cheapflightapp.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightList {

    private List<Flight> flights;

    public void addFlightToFlights(){
        flights = new ArrayList<>();
        FlightsDB flightsDB = new FlightsDB();
        flightsDB.addAllFights();
        flights = flightsDB.getFlightsDB();
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
