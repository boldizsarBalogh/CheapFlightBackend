package com.codecool.cheapflightapp.Service;

import com.codecool.cheapflightapp.model.City;
import com.codecool.cheapflightapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

}
