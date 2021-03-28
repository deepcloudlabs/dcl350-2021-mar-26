package com.example.lottery.client;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LotteryConsumerService {
	@Autowired
	private DiscoveryClient discoveryClient;
	private List<ServiceInstance> servers;
	private AtomicInteger counter = new AtomicInteger(0);
	@Autowired
	private RestTemplate restTemplate;

	@PostConstruct
	public void init() {
		servers = discoveryClient.getInstances("lottery"); // spring.application.name
	}

	@Scheduled(fixedRate = 1_000)
	public void callLotteryService() {
		int index = counter.getAndIncrement() % servers.size();
		var server = servers.get(index);
		String url = String.format("http://%s:%d/numbers?max=60&size=6&column=5", server.getHost(), server.getPort());
		var response = restTemplate.getForEntity(url, String.class).getBody();
		System.out.println(response);
	}
}
