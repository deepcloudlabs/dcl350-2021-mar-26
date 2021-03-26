package com.example.lottery.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;
import com.example.mottery.service.business.StandardLotteryService;

@Configuration
@ComponentScan(basePackages = {"com.example.mottery"})
public class AppConfig {

	@Autowired 
	private ApplicationContext context;
	
	@PostConstruct
	public void init() {
	   context.getBeansOfType(Object.class)
	          .forEach( (label,comp) -> System.err.println(label+": "+comp.getClass().getSimpleName()));
	}
	
	@Bean
	public LotteryService standard(RandomNumberService service) {
		return new StandardLotteryService(service);
	}
}
