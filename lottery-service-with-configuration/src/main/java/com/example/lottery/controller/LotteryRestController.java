package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("numbers")
@RequestScope
@CrossOrigin
public class LotteryRestController {
	@Autowired
	private LotteryService lotteryService;

	@GetMapping(params = { "column" })
	public List<List<Integer>> getNumbers(@RequestParam int column) {
		return lotteryService.draw(column);
	}
}
