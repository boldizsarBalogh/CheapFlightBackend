package com.codecool.cheapflightapp.repository;

import com.codecool.cheapflightapp.model.Flight;
import com.codecool.cheapflightapp.model.ResultDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository  extends JpaRepository<Flight, Integer> {


    @Query("SELECT new com.codecool.cheapflightapp.model.ResultDto(f.company, st.name, at.name, f.date, f.startTime, f.arriveTime, f.confort, f.price) " +
            "from com.codecool.cheapflightapp.model.Flight f " +
            "join  f.startTown st " +
            "join  f.arriveTown at " +
            "WHERE st.name = :departure and at.name= :arrive" +
            " order by f.price")
    List<ResultDto> findFlightByStartTownAndArriveTown(@Param("departure") String start, @Param("arrive") String arrive);

    void deleteAll();

    List<Flight> findAll();

    @Query("SELECT new com.codecool.cheapflightapp.model.ResultDto(f.company, st.name, at.name, f.date, f.startTime, f.arriveTime, f.confort, f.price) " +
            "from com.codecool.cheapflightapp.model.Flight f " +
            "join  f.startTown st " +
            "join  f.arriveTown at " +
            "order by f.price")
    List<ResultDto> getFlightsByPrice();
}
