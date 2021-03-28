package com.example.application;

import java.util.concurrent.TimeUnit;

import com.example.service.AsyncLotteryService;

public class AsyncLotteryApplication {

	public static void main(String[] args) {
		System.err.println("App is running...");
		var lotteryService = new AsyncLotteryService();
		// sync call
		lotteryService.draw(60, 6)
				.thenAcceptAsync(numbers -> System.err.println(Thread.currentThread().getName() + ": " + numbers));
		for (var i = 0; i < 100; ++i)
			System.err.println(Thread.currentThread().getName() + " - i: " + i);
		System.err.println("Completed.");
		try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) { }			
		System.err.println("Done.");
	}

}
