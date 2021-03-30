package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("numbers")
@CrossOrigin
public class LotteryRestController {
	@Autowired
	private LotteryService lotteryService;
	@Value("${server.port}")
	private int port;

	@GetMapping
	public List<List<Integer>> getNumbers() {
		System.err.println("Serving at port " + port);
		return lotteryService.draw(60, 6, 2);
	}
}
