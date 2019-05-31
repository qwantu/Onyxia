package com.onyxia.servicesRegisteryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServicesRegisteryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesRegisteryServerApplication.class, args);
	}

}
