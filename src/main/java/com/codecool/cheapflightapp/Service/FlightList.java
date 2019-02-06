package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.DB.FlightsDB;
import com.codecool.cheapflightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightList {

    private List<Flight> flights;

    @Autowired
    private FlightCreator flightCreator;

    public void addFlightToFlights(){
        flights = new ArrayList<>();
        FlightsDB flightsDB = new FlightsDB();
        flights = flightsDB.addAllFights();
        List<Flight> filterFlights = new ArrayList<>();
        for(Flight flight : flights){
           // if(flight.getArriveTown().equals(arrive)){
                filterFlights.add(flight);
           // }
        }
        flights = filterFlights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
