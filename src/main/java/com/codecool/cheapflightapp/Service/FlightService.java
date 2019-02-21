package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.model.ResultDto;
import com.codecool.cheapflightapp.repository.FlightRepository;
import com.codecool.cheapflightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> addFlightToFlights(){
        return flightRepository.findAll();
    }

    public List<ResultDto> getNCheapest(int numOfCheapest){
        List<ResultDto> flights = flightRepository.getFlightsByPrice();
        List<ResultDto> result = new ArrayList<>();
        for (int i = 0; i < numOfCheapest; i++) {
                result.add(flights.get(i));
        }
        return result;
    }

}
