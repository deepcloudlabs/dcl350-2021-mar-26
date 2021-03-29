package com.example.lottery.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;

@Service
@RefreshScope
public class StandardLotteryService implements LotteryService {
	@Value("${lottery.max}")
	private int lotteryMax;
	@Value("${lottery.size}")
	private int lotterySize;
	
	@Override
	@Cacheable(value = "numbers", key="#column")
	@CacheEvict
	@CachePut
	public List<List<Integer>> draw(int column) {
		System.err.println(lotteryMax+", "+lotterySize);
		return IntStream.range(0, column)
				.mapToObj(i -> ThreadLocalRandom.current()
								    .ints(1, lotteryMax)
									.distinct()
									.limit(lotterySize)
									.sorted()
									.boxed()
									.collect(Collectors.toList())
			).collect(Collectors.toList());
	}

}
