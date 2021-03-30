package com.example.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// http://localhost:9200/hr/api/v1/swagger-ui.html
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class HrMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrMicroserviceApplication.class, args);
	}

}
