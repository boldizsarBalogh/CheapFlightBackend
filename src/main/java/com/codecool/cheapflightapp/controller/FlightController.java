package com.codecool.cheapflightapp.controller;


import com.codecool.cheapflightapp.Service.FlightService;
import com.codecool.cheapflightapp.Service.ScraperService;
import com.codecool.cheapflightapp.model.Flight;
import com.codecool.cheapflightapp.model.ResultDto;
import com.codecool.cheapflightapp.model.SearchHistory;
import com.codecool.cheapflightapp.repository.FlightRepository;
import com.codecool.cheapflightapp.repository.SearchHistoryRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ScraperService scraperService;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @GetMapping("/")
    public List<Flight> flightList(){
        return flightService.addFlightToFlights();
    }

    @GetMapping("/search")
    public List<ResultDto> getFlights(@RequestParam Map<String, String> searchQuery)  {

        String startTown= searchQuery.get("startTown");
        String arriveTown= searchQuery.get("arriveTown");
        SearchHistory  searchHistory = searchHistoryRepository.findSearchByOriginDestination(startTown,arriveTown);
        if(searchHistory == null){
                SearchHistory current = SearchHistory.builder()
                        .timeOfSearch(LocalTime.now())
                        .origin(startTown)
                        .destination(arriveTown)
                        .build();
                searchHistoryRepository.save(current);
                flightRepository.deleteAll();
                scraperService.scrapeExpendia(startTown,arriveTown);
            return flightRepository.findFlightByStartTownAndArriveTown(startTown, arriveTown);

        }else if(ChronoUnit.MINUTES.between(searchHistory.getTimeOfSearch(), LocalTime.now()) > 10) {
            searchHistoryRepository.deleteAll();
            flightRepository.deleteAll();
            scraperService.scrapeExpendia(startTown, arriveTown);
            return flightRepository.findFlightByStartTownAndArriveTown(startTown, arriveTown);
        }else{
            return flightRepository.findFlightByStartTownAndArriveTown(startTown, arriveTown);
        }




        }

    @GetMapping("/cheapest")
    public List<ResultDto> getCheapestFlights(){
        return flightService.getNCheapest(3);
    }




}
