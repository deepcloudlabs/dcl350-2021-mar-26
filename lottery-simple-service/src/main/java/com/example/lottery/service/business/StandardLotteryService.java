package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;

@Service
public class StandardLotteryService implements LotteryService {

	@Autowired
	private RandomNumberService service;

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate(() -> service.generate(1, max)).distinct().limit(size).sorted().boxed()
				.collect(Collectors.toList());
	}

}
