package com.codecool.cheapflightapp.controller;


import com.codecool.cheapflightapp.Service.CityService;
import com.codecool.cheapflightapp.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public List<City> sendCities() {
        return cityService.getAllCities();
    }
}
