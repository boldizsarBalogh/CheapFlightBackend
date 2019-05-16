package com.codecool.cheapflightapp.Service;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;




@Service
public class ScraperService {
    private String chromeDriverPath;
    private ChromeOptions chromeOptions;
    private WebDriver webDriver;
    private JavascriptExecutor javascriptExecutor;
    private final String ExpediaURL = "https://www.expedia.com/";
    private final String UserAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36";

    public void ChromeDriverInitalizer(){
        this.chromeDriverPath = "/usr/bin/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        this.chromeOptions = new ChromeOptions();
        this.chromeOptions.addArguments( "user-agent="+UserAgent,"--headless","--window-size=1920,1200","--ignore-certificate-errors");
        this.webDriver = new ChromeDriver(chromeOptions);
        this.javascriptExecutor = (JavascriptExecutor)webDriver;
    }
    public String scrapeExpendia() {
        webDriver.get(ExpediaURL);
        System.out.println(webDriver.getTitle());
        WebElement flightOnly = webDriver.findElement(By.id("tab-flight-tab-hp"));
        flightOnly.click();
        webDriver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();
//        WebElement originField = webDriver.findElement(By.id("flight-origin-hp-flight"));
        javascriptExecutor.executeScript("document.getElementById('flight-origin-hp-flight').value='BUD'");
//        WebElement destinationField = webDriver.findElement(By.id("flight-destination-hp-flight"));
        javascriptExecutor.executeScript("document.getElementById('flight-destination-hp-flight').value='LON'");
        WebElement datePicker = webDriver.findElement(By.id("flight-departing-single-hp-flight"));
        datePicker.clear();
        datePicker.sendKeys("06/21/2019");
        flightOnly.click();
        webDriver.findElement(By.xpath("//button[@class='btn-primary btn-action gcw-submit']")).click();
        System.out.println(webDriver.getTitle());
        return webDriver.getTitle();



    }




}
