package com.codecool.cheapflightapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultDto {


    private String company;
    private String startTown;
    private String arriveTown;
    private String date;
    private String startTime;
    private String arriveTime;
    private String confort;
    private double price;
}