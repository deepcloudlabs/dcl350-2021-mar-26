package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Ticker;

@SuppressWarnings("deprecation")
@Service
public class BinanceSyncRestClient {

	@Value("${binance.rest.url}")
	private String restUrl;

	//@Scheduled(fixedRate = 3_000)
	public void syncCallBinanceTickerService() {
		var rt = new RestTemplate();
		var ticker = rt.getForEntity(restUrl, Ticker.class).getBody();
		System.err.println(ticker);
	}

	@Scheduled(fixedRate = 3_000)
	public void asyncCallBinanceTickerService() {
		var rt = new AsyncRestTemplate();
		rt.getForEntity(restUrl, Ticker.class)
				       .addCallback(System.out::println, System.err::println);
		
	}
}
