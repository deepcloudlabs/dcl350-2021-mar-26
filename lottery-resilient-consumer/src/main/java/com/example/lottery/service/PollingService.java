package com.example.lottery.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PollingService {

	@Autowired
	private LotteryClientService lotteryClientService;
	private ExecutorService pool = Executors.newFixedThreadPool(20);
	
	@Scheduled(fixedRate = 10_000)
	public void run() {
		System.err.println("PollingService::run - "+Thread.currentThread().getName());
		for (var i=0;i<20;++i) {
			var j = i;
			pool.submit(() -> {
				var numbers = lotteryClientService.callLotteryService();
				System.err.println("i: "+j+", numbers= "+numbers);
			});
		}
	}
}
