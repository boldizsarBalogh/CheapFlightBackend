package com.codecool.cheapflightapp.repository;

import com.codecool.cheapflightapp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAll();

    @Query("SELECT c From City c where c.name= :name")
    City findCityByName(String name);
}
