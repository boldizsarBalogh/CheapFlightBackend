## Cheap Flight Backend Application

### What is the Cheap Flight app?
The application's main purpose is to find cheapest flight possible 
between two cities. The development is  in its early stages at the moment.

### Currently implemented features

* Generates random flight data to populate the Database
* Currently There are 4 available API endpoints:
    * The "/cities" endpoints gives back all the possible destination/departure cities as a Jason array.
    * The "/" endpoints gives back all the flights as a JSON array.
    * The "/search" endpoint  expects "startTown" and "arriveTown" query parameters in the URI and gives 
    back all the result flights
    * The "/cheapest" endpoint gives back the 3 currently cheapest flights from the database.

### Future Plans
* Use real data instead of the mock database with scraping multiple existing travel sites
and evaluate the result based on price
* Write tests.
* Implement proper API documentation with Swagger

## Install notes
* Maven is used as a build tool for the project 
You can find more information at the official maven website(https://maven.apache.org/install.html)
* You can run the project with the "mvn spring-boot:run" command