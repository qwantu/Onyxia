# Onyxia


### Architecture


__Microservices system__ : Eureka / Zuul (proxy)


Eureka client === 1 microservice (Port => define yourself in config)

Eureka server === services registry (microservices and even zuul proxy microservice / (Port => 5000)

Zuul proxy (load balancing) === proxy (Port => 8762)


Note: 

   **see available microservices** => localhost:8762/actuator/routes
    
   **see mappings from microservice** => localhost:PORT/actuator/mappings
  

