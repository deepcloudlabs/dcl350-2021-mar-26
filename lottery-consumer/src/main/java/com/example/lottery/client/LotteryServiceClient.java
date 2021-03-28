package com.example.lottery.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;

@Service
public class LotteryServiceClient {
	@Autowired
	private LotteryService lotteryService;
	
	@Scheduled(fixedRate = 1_000)
	public void callLotteryService() {
		System.err.println(lotteryService.sayilariGetir(100, 3, 2));
	}
}
