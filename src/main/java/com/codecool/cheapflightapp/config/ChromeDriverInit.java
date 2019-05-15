package com.codecool.cheapflightapp.config;

import com.codecool.cheapflightapp.Service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChromeDriverInit {
    @Autowired
    private ScraperService scraperService;

    @Bean

    public void initDrivers(){
        scraperService.ChromeDriverInitalizer();
    }


}
