package com.codecool.cheapflightapp.Service;
import com.codecool.cheapflightapp.model.Flight;
import com.codecool.cheapflightapp.repository.CityRepository;
import com.codecool.cheapflightapp.repository.FlightRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class ScraperService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    CityRepository cityRepository;


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
        this.chromeOptions.addArguments( "user-agent="+UserAgent,"--window-size=1920,1200","--headless","--ignore-certificate-errors");
        this.webDriver = new ChromeDriver(chromeOptions);
        this.javascriptExecutor = (JavascriptExecutor)webDriver;
    }

    private LocalTime toLocalTimeForExpendia(String timeString){

        String timeStringMerediem = timeString.substring(timeString.length()-2).toUpperCase();
        String timeSubString = timeString.substring(0,timeString.length()-2);
        String[] time = timeSubString.split(":");
        if(timeStringMerediem.equals("AM")){
            if(Integer.valueOf(time[0]) == 12){
                return LocalTime.of(0,Integer.valueOf(time[1]));
            }
            return LocalTime.of(Integer.valueOf(time[0]),Integer.valueOf(time[1]));
        }else{
            if(Integer.valueOf(time[0])== 12){
                return LocalTime.of(Integer.valueOf(time[0]),Integer.valueOf(time[1]));
            }
            return LocalTime.of(Integer.valueOf(time[0]) + 12, Integer.valueOf(time[1]));
        }

    }
    public String scrapeExpendia(String startTown, String destination) {
        List<WebElement> departures;
        List<WebElement> arrivals;
        List<WebElement> priceElements;
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/uuuu");
        String formattedDate = tomorrow.format(formatter);


        webDriver.get(ExpediaURL);
        System.out.println(webDriver.getTitle());
        WebElement flightOnly = webDriver.findElement(By.id("tab-flight-tab-hp"));
        flightOnly.click();
        webDriver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();
        javascriptExecutor.executeScript("document.getElementById('flight-origin-hp-flight').value=" + "'"+ startTown + "'");
        javascriptExecutor.executeScript("document.getElementById('flight-destination-hp-flight').value=" +"'"+ destination +"'");
        WebElement datePicker = webDriver.findElement(By.id("flight-departing-single-hp-flight"));
        datePicker.clear();
        datePicker.sendKeys(formattedDate);
        flightOnly.click();
        webDriver.findElement(By.xpath("//button[@class='btn-primary btn-action gcw-submit']")).click();
        departures = webDriver.findElements(By.xpath("//span[@data-test-id='departure-time']"));
        arrivals = webDriver.findElements(By.xpath("//span[@data-test-id='arrival-time']"));
        priceElements = webDriver.findElements(By.xpath("//span[@data-test-id='listing-price-dollars']"));


        for(int i = 0 ; i < departures.size();i++){


            Flight current = Flight.builder()
                    .confort("Economy")
                    .startTown(cityRepository.findCityByName(startTown))
                    .arriveTown(cityRepository.findCityByName(destination))
                    .startTime(toLocalTimeForExpendia(departures.get(i).getText()))
                    .arriveTime(toLocalTimeForExpendia(arrivals.get(i).getText()))
                    .company("some Company")
                    .date(LocalDate.parse(formattedDate,formatter))
                    .price(Double.valueOf(priceElements.get(i).getText().substring(1).replace(",",".")))
                    .build();
            flightRepository.save(current);
        }
        return webDriver.getTitle();



    }




}
