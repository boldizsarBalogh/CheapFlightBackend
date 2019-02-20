package com.codecool.cheapflightapp.repository;

import com.codecool.cheapflightapp.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository  extends JpaRepository<Flight, Integer> {

    List<Flight> findAll();

}
