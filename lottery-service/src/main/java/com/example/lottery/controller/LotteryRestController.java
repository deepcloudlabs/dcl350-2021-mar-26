package com.example.lottery.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("numbers")
//@RequestScope
@CrossOrigin
public class LotteryRestController {
	// DI: @Autowired, @Resource, @Inject (Java EE -> CDI)
	@Inject
	private LotteryService lotteryService;
	@Value("${server.port}")
	private int port;
	
	@GetMapping(params = { "max", "size", "column" })
	public List<List<Integer>> getNumbers(@RequestParam int max, @RequestParam int size, @RequestParam int column) {
		System.err.println("Serving at port "+port);
		return lotteryService.draw(max, size, column);
	}
}
