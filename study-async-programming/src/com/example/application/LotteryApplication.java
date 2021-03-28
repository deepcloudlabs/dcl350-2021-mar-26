package com.example.application;

import com.example.service.LotteryService;

public class LotteryApplication {

	public static void main(String[] args) {
		System.err.println("App is running...");
		LotteryService lotteryService = new LotteryService();
		// sync call
		var numbers = lotteryService.draw(60, 6);
		System.err.println(Thread.currentThread().getName() + ": " + numbers);
		System.err.println("Done.");
	}

}
