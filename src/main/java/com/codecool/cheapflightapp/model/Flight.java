package com.codecool.cheapflightapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String startTown;
    private String arriveTown;
    private String date;
    private String startTime;
    private String arriveTime;
    private String confort;
    private double price;

    public Flight(String company, String start, String arrive, String date, String startTime, String arriveTime, String confort, double price) {
        this.company = company;
        this.startTown = start;
        this.arriveTown = arrive;
        this.date = date;
        this.startTime = startTime;
        this.arriveTime = arriveTime;
        this.confort = confort;
        this.price = price;
    }

    public Flight() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartTown() {
        return startTown;
    }

    public void setStartTown(String startTown) {
        this.startTown = startTown;
    }

    public String getArriveTown() {
        return arriveTown;
    }

    public void setArriveTown(String arriveTown) {
        this.arriveTown = arriveTown;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getConform() {
        return confort;
    }

    public void setConform(String confort) {
        this.confort = confort;
    }

    public String getConfort() {
        return confort;
    }

    public void setConfort(String confort) {
        this.confort = confort;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
