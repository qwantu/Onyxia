package com.onyxia.eurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient // this annotation make spring to understand this is a micro service ready to be used into eureka server (visible)
@RestController
public class EurekaClientApplication {
	//https://stackoverflow.com/questions/36557646/what-is-eureka-service-eureka-client-eureka-instance-and-eureka-server

	//List endpoints actuator : https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html

	//click on micro service from eureka server and add /home to access this path
	@RequestMapping("/home")
	public String home(){
		return "HOME";
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}
