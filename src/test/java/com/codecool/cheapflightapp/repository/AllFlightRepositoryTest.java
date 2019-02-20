package com.codecool.cheapflightapp.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllFlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

//    @Test
//    public void saveANewFlight(){
//        Flight newFlight = Flight.builder()
//                .company("Ryanair")
//                .startTown("BUD")
//                .arriveTown("MAD")
//                .date("2019-03-01")
//                .startTime("17:45")
//                .arriveTime("20:20")
//                .confort("Turista")
//                .price(99.9)
//                .build();
//        flightRepository.save(newFlight);
//
//        List<Flight> newFlights = flightRepository.findAll();
//        assertThat(newFlights).hasSize(1);
//
//    }

}