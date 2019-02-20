package com.codecool.cheapflightapp.Repository;

import com.codecool.cheapflightapp.model.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllFlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void saveANewFlight(){
        Flight newFlight = Flight.builder()
                .company("Ryanair")
                .startTown("BUD")
                .arriveTown("MAD")
                .date("2019-03-01")
                .startTime("17:45")
                .arriveTime("20:20")
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight);

        List<Flight> newFlights = flightRepository.findAll();
        assertThat(newFlights).hasSize(1);

    }

    @Test
    public void findFlight(){
        Flight newFlight = Flight.builder()
                .company("Ryanair")
                .startTown("BUD")
                .arriveTown("MAD")
                .date("2019-03-01")
                .startTime("17:45")
                .arriveTime("20:20")
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight);

        Flight newFlight2 = Flight.builder()
                .company("Ryanair")
                .startTown("BUD")
                .arriveTown("ROM")
                .date("2019-03-01")
                .startTime("17:45")
                .arriveTime("20:20")
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight2);

        Flight newFlight3 = Flight.builder()
                .company("Ryanair")
                .startTown("BUD")
                .arriveTown("ROM")
                .date("2019-04-01")
                .startTime("17:45")
                .arriveTime("20:20")
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight3);


        List<Flight> flights = flightRepository.findFlightByStartTownAndArriveTown("BUD", "ROM");
        assertEquals(2, flights.size());
    }

}