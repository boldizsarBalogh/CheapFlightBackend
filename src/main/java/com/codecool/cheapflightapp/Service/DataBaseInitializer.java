package com.codecool.cheapflightapp.Service;



import com.codecool.cheapflightapp.Repository.FlightRepository;
import com.codecool.cheapflightapp.model.Flight;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


@Data
@Service
public class DataBaseInitializer {
    Random random = new Random();
    String[] cities = {"Budapest","Berlin","Madrid","Paris","Brussels"};
    String[] companies = {"Wizair","Ryanair","Lufthansa"};
    String[] conforts = {"Business","Economy"};
    DecimalFormat df = new DecimalFormat("#.#");

    private LocalDate dateRandomizer(){
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.of(2019, 4, 30).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;

    }


    public void initalize(FlightRepository flightRepository,int recordNumber){


        for(int i = 1; i <= recordNumber;i++){
            String startTown = cities[random.nextInt(5)];
            String arriveTown = cities[random.nextInt(5)];
            LocalTime startTime = LocalTime.MIN.plusSeconds(random.nextLong());
            Double price = Double.parseDouble(df.format(ThreadLocalRandom.current().nextDouble(50, 100)));
            while(startTown.equals(arriveTown)){
                arriveTown = cities[random.nextInt(5)];
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
