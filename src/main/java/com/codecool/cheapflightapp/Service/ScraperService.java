package com.codecool.cheapflightapp.Service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;


@Service
public class ScraperService {
    private String chromeDriverPath;
    private ChromeOptions chromeOptions;
    private WebDriver webDriver;

    public void ChromeDriverInitalizer(){
        this.chromeDriverPath = "/usr/bin/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        this.chromeOptions = new ChromeOptions();
        this.chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        this.webDriver = new ChromeDriver(chromeOptions);
    }
    public void printPageTitle(){
        webDriver.get("https://google.com");
        System.out.println(webDriver.getTitle());
    }




}
