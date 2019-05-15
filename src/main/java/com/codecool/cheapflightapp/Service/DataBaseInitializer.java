package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.repository.CityRepository;
import com.codecool.cheapflightapp.repository.FlightRepository;
import com.codecool.cheapflightapp.model.City;
import com.codecool.cheapflightapp.model.Flight;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Data
@Service
public class DataBaseInitializer {
    private Random random = new Random();
    private String[] companies = {"Wizair","Ryanair","Lufthansa"};
    private String[] conforts = {"Business","Economy"};
    private DecimalFormat df = new DecimalFormat("#.#");


    private LocalDate dateRandomizer(){
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.of(2019, 6, 30).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    public void initializeCities(String[] cities, CityRepository cityRepository){
        for(int i = 0; i < cities.length;i++){
            cityRepository.save(City.builder()
                    .name(cities[i])
                    .build());
        }
    }

    public void initalizeFlights(FlightRepository flightRepository, int flightCount, List<City> cities){


        for(int i = 1; i <= flightCount;i++){
            City startTown = cities.get(random.nextInt(cities.size()));
            City arriveTown = cities.get(random.nextInt(cities.size()));
            LocalTime startTime = LocalTime.MIN.plusSeconds(random.nextLong());
            Double price = Double.parseDouble(df.format(ThreadLocalRandom.current().nextDouble(50, 100)));
            while(startTown.equals(arriveTown)){
                arriveTown = cities.get(random.nextInt(cities.size()));
            }
            Flight current = Flight.builder()
                    .confort(conforts[random.nextInt(2)])
                    .startTown(startTown)
                    .arriveTown(arriveTown)
                    .startTime(startTime)
                    .arriveTime(startTime.plusHours(4))
                    .company(companies[random.nextInt(3)])
                    .date(dateRandomizer())
                    .price(price)
                    .build();
            flightRepository.save(current);
        }
    }
}
