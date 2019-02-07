package com.codecool.cheapflightapp.DB;

import com.codecool.cheapflightapp.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsDB {

    private List<Flight> flightsDB = new ArrayList<>();

    public List<Flight> addAllFights(){
        flightsDB.add(new Flight("Ryanair", "BUD", "MAD", "2019-03-01", "17:45", "20:20", "Turista", 79.95));
        flightsDB.add(new Flight("Wizzapr", "BUD", "BER", "2019-03-02", "17:45", "20:20", "Turista", 29.95));
        flightsDB.add(new Flight("AirFrance", "BUD", "PAR", "2019-03-03", "17:45", "20:20", "Turista", 53.95));
        return flightsDB;
    }

}
