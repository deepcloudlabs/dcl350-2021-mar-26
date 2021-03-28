package com.example.lottery.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "lottery")
public interface LotteryService {

	@GetMapping(value="/numbers",params= {"max", "size", "column"})
	public List<List<Integer>> sayilariGetir(
			@RequestParam int max,
			@RequestParam int size,
			@RequestParam int column);
}
