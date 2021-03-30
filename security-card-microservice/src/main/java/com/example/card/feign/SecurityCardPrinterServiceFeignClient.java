package com.example.card.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.card.dto.CardInfo;

@FeignClient(name = "card-hw-printer")
public interface SecurityCardPrinterServiceFeignClient {

	@PostMapping("/api/v1/resources/cards")
	public void print(@RequestBody CardInfo cardInfo);
}
