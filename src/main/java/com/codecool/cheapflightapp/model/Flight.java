package com.codecool.cheapflightapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;

    @ManyToOne
    private City startTown;

    @ManyToOne
    private City arriveTown;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime arriveTime;
    private String confort;
    private double price;

}
