package com.codecool.cheapflightapp.repository;

import com.codecool.cheapflightapp.model.City;
import com.codecool.cheapflightapp.model.Flight;
import com.codecool.cheapflightapp.model.ResultDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllFlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void saveANewFlight(){
        City bud = City.builder()
                .name("BUD")
                .build();
        City mad = City.builder()
                .name("MAD")
                .build();

        cityRepository.save(bud);
        cityRepository.save(mad);


        Flight newFlight = Flight.builder()
                .company("Ryanair")
                .startTown(bud)
                .arriveTown(mad)
                .date(LocalDate.of(2019,03,01))
                .startTime(LocalTime.of(17,45))
                .arriveTime(LocalTime.of(20,20))
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight);

        List<Flight> newFlights = flightRepository.findAll();
        assertThat(newFlights).hasSize(1);

    }

    @Test
    public void findFlight(){
        City bud = City.builder()
                .name("BUD")
                .build();
        City mad = City.builder()
                .name("MAD")
                .build();
        City rom = City.builder()
                .name("ROM")
                .build();
        cityRepository.save(bud);
        cityRepository.save(mad);
        cityRepository.save(rom);


        Flight newFlight = Flight.builder()
                .company("Ryanair")
                .startTown(bud)
                .arriveTown(mad)
                .date(LocalDate.of(2019,03,01))
                .startTime(LocalTime.of(17,45))
                .arriveTime(LocalTime.of(20,20))
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight);

        Flight newFlight2 = Flight.builder()
                .company("Ryanair")
                .startTown(bud)
                .arriveTown(rom)
                .date(LocalDate.of(2019,03,01))
                .startTime(LocalTime.of(17,45))
                .arriveTime(LocalTime.of(20,20))
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight2);

        Flight newFlight3 = Flight.builder()
                .company("Wizzair")
                .startTown(bud)
                .arriveTown(rom)
                .date(LocalDate.of(2019,03,01))
                .startTime(LocalTime.of(17,45))
                .arriveTime(LocalTime.of(20,20))
                .confort("Turista")
                .price(99.9)
                .build();
        flightRepository.save(newFlight3);


        List<ResultDto> flights = flightRepository.findFlightByStartTownAndArriveTown("BUD", "ROM");
        assertEquals(2, flights.size());
    }

}