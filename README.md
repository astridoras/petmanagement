# Pet management

## Requirements for running the application
* Java17
* Angular14
* Gradle
* Node 18

## Overview
* `pet-client` runs a Angular-based web UI
* `src` (runs a back-end application using java, in the future will be moved in a separate package named `pet-server`)
* `H2-database` runs a database

## Running FE application:
* The application is served on port http://localhost:4200/
* For running FE navigate to pet-client package from root (cd pet-client)
* and run:
```
npm install
npm start
```

## Running BE application:
Run gradle bootRun from the project root in CLI or run src/test/java/com/pet/petmanagement/ManagementServiceIntegrationTest.java

* The application is served on port 8080:
  http://localhost:8080/
* The Swagger UI is available at: http://localhost:8080/swagger-ui/index.html#/

## Accessing H2 database console:
* H2 Console is available at http://localhost:8080/h2-console/login.jsp?jsessionid=bd681a88a5875b986a8552c5cd951262
* Driver Class: org.h2.Driver
* JDBC URL: jdbc:h2:mem:pet_management_db
* User Name: defined at application.properties
* Password: defined at application.properties

## Tests
Tests are located src/test/java/com/pet/petmanagement/ManagementServiceIntegrationTest

## To do and improvements:
* Fix back-end application directory - move in a separate package named `pet-client`
* Separate DB schema for business table (at the moment everything is under public)
* Edit pet method implementation
* Login implementation in Angular
* Sorting of pets in All pets table
* FE error handling
* User password in DB should be hashed (now displayed as entered)
* More tests for back-end
* Tests for front-end need to fixed
* Add method that validates that pets with same type and code can not be added to avoid same pet adding
