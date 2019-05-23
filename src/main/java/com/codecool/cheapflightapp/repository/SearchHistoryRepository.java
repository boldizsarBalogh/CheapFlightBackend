package com.codecool.cheapflightapp.repository;

import com.codecool.cheapflightapp.model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Integer> {

    @Query("SELECT sh from" +
    " com.codecool.cheapflightapp.model.SearchHistory sh " +
    " where sh.origin= :origin and sh.destination= :destination" +
            " order by sh.time desc ")
    List<SearchHistory> findSearchByOriginDestination(@Param("origin") String origin, @Param("destination") String destination);
}
