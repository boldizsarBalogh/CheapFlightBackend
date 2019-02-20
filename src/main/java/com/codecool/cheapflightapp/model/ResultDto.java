package com.codecool.cheapflightapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ResultDto {


    private String company;
    private String startTown;
    private String arriveTown;
    private LocalDate date; // localDate
    private LocalTime startTime;// localTime
    private LocalTime arriveTime; // City
    private String confort;
    private double price;
}