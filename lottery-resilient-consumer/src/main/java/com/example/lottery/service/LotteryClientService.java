package com.example.lottery.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;

@Service
public class LotteryClientService {
	private String cache = "[4,8,15,16,23,49]";

	// @Retry(name = "lottery", fallbackMethod = "callFallbackLottery")
	// @TimeLimiter
	// @RateLimiter(name = "lottery", fallbackMethod = "callFallbackLottery")
	// @CircuitBreaker(name = "lottery", fallbackMethod = "callFallbackLottery")
	@Bulkhead(name = "lottery", type = Type.THREADPOOL, fallbackMethod = "callFallbackLottery")
	public String callLotteryService() {
		System.err.println("LotteryClientService::callLotteryService - " + Thread.currentThread().getName());
		var template = new RestTemplate();
		cache = template.getForEntity("http://localhost:10200/numbers?column=2&max=60&size=6", String.class).getBody();
		return cache;
	}

	public String callFallbackLottery(Exception e) {

		return cache;
	}
}
