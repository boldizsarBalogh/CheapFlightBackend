package com.codecool.cheapflightapp.repository;

import com.codecool.cheapflightapp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAll();
}
