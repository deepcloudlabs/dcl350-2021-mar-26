package com.example.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AsyncLotteryService {
	//sync
	public CompletableFuture<List<Integer>> draw(int max, int size){
		return CompletableFuture.supplyAsync(() -> {
			try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { }			
			return ThreadLocalRandom.current().ints(1,max).distinct()
					.limit(size).sorted().boxed().collect(Collectors.toList());
		});
	}
}
