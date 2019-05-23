package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.model.ResultDto;
import com.codecool.cheapflightapp.model.SearchHistory;
import com.codecool.cheapflightapp.repository.CityRepository;
import com.codecool.cheapflightapp.repository.FlightRepository;
import com.codecool.cheapflightapp.model.Flight;
import com.codecool.cheapflightapp.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private SearchHistoryRepository searchHistoryRepository;
    @Autowired
    private ScraperService scraperService;
    @Autowired
    private CityRepository cityRepository;

    private void saveCurrentSearchHistory(String startTown, String arriveTown){
        SearchHistory current = SearchHistory.builder()
                .time(LocalTime.now())
                .origin(startTown)
                .destination(arriveTown)
                .build();
        searchHistoryRepository.save(current);
    }

    private boolean isFlightsSearched(String startTown, String arriveTown){
        List<SearchHistory>  searchHistory = searchHistoryRepository.findSearchByOriginDestination(startTown,arriveTown);
        if(searchHistory.size() == 0){

            saveCurrentSearchHistory(startTown,arriveTown);
            return false;

        }else if(ChronoUnit.MINUTES.between(searchHistory.get(0).getTime(), LocalTime.now()) > 10) {

            saveCurrentSearchHistory(startTown,arriveTown);
            return false;
        }else{
            return true;
        }
    }
    @Transactional
    public List<ResultDto> findFlightsByOriginAndDestination(String origin,String destination){
        if(!isFlightsSearched(origin,destination)) {
            flightRepository.deleteFlightsByStartTownAndArriveTown(cityRepository.findCityByName(origin),cityRepository.findCityByName(destination));
            scraperService.scrapeExpendia(origin,destination);
            return flightRepository.findFlightByStartTownAndArriveTown(origin, destination);
        }else{
            return flightRepository.findFlightByStartTownAndArriveTown(origin, destination);
        }
    }

    public List<Flight> findAllFlights(){
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
