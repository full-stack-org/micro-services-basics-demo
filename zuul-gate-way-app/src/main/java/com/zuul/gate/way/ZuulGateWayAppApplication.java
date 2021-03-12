package com.zuul.gate.way;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulGateWayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateWayAppApplication.class, args);
	}

}
