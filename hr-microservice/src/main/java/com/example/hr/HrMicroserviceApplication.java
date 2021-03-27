package com.example.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:9200/hr/api/v1/swagger-ui.html
@SpringBootApplication
public class HrMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrMicroserviceApplication.class, args);
	}

}
