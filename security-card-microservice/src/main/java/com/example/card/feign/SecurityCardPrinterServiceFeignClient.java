package com.example.card.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.card.dto.CardInfo;

@FeignClient(name = "card-printer")
public interface SecurityCardPrinterServiceFeignClient {

	@PostMapping("/cards")
	public void print(@RequestBody CardInfo cardInfo);
}
