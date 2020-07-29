# REST API with Spring Boot, H2, JPA and Hibernate 

This is a sample Java / Maven / Spring Boot (version 2.3.2) application that can be used as a starter for creating an API Rest with elementary CRUD operations.


## How to Run 


* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can run the following:
```
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```

The app will start running at <http://localhost:8080>.
The H2 web ui at <http://localhost:8080/h2>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /users/{id}
    
    POST /users
	
	DELETE /users/{id}
    
    GET /loans?page={page}&size={size}&user_id={userId}
