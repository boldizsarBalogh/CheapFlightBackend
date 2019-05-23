package com.codecool.cheapflightapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
public class SearchHistory {

    @Id
    @GeneratedValue
    private int id;

    private LocalTime time;
    private String origin;
    private String destination;
}
