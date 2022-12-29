# Pet management

## Requirements for running the application
* Java17
* Angular14

## Overview
* `pet-client` runs a Angular-based web UI
* `petmanagement11.src` (in the future will be moved in a separate package named `pet-server` runs a back-end application using java
* `H2-database` runs a database

> Swagger UI is available at: http://localhost:8080/swagger-ui/index.html#/
> Angular UI is available at: http://localhost:4200/users/1/pets

## Running FE application:
* The application is served on port http://localhost:4200/
* For running FE navigate to pet-client package from root (cd pet-client)
* and run:
```
npm install && ng serve
```

## Running BE application:
* For running BE navigate to src\main\java\com\pet\petmanagement\PetmanagementApplication.java and run

## Running H2 database:
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
* User password in DB should be hashed (now displayed as entered)
* More tests for back-end
* Tests for front-end 
* Add method that validates that pets with same type and code can not be added to avoid same pet adding
