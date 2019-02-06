package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightCreator {

    public Flight createFlight(){
        Flight flight = new Flight();
        flight.setCompany("Wizzair");
        flight.setStartTown("BUD");
        flight.setArriveTown("MAD");
        return flight;
    }

}
