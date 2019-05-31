package com.onyxia.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // indicate to eureka server that microservice must be read as ZuulProxy (nothing to configure)
@EnableDiscoveryClient // make zuul used against eureka server that manage our eureka clients (microservices) => dont forget to configure (eureka server url etc)
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
