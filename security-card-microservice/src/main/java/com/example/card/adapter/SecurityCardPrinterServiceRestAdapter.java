package com.example.card.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card.domain.SecurityCard;
import com.example.card.dto.CardInfo;
import com.example.card.feign.SecurityCardPrinterServiceFeignClient;
import com.example.card.infrastructure.SecurityCardPrinterService;

@Service
public class SecurityCardPrinterServiceRestAdapter implements SecurityCardPrinterService {
	@Autowired
	private SecurityCardPrinterServiceFeignClient feignClient;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void printCard(SecurityCard securityCard) {
		CardInfo cardInfo= modelMapper.map(securityCard, CardInfo.class);
		feignClient.print(cardInfo);
	}

}
