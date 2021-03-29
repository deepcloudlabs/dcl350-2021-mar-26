package com.example.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// curl -X POST localhost:6400/actuator/refresh -d {} -H "Content-Type: application/json"
@SpringBootApplication
public class LotteryServiceWithConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryServiceWithConfigurationApplication.class, args);
	}

}
