package com.example.card.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card.application.SecurityCardApplication;
import com.example.card.domain.CardId;
import com.example.card.domain.SecurityCard;
import com.example.card.dto.BlockSecurityCardResponse;
import com.example.card.message.PrintSecurityCardMessage;

@Service
public class SecurityCardService {
	@Autowired
	private SecurityCardApplication securityCardApplication;
	@Autowired
	private ModelMapper modelMapper;
	
	public BlockSecurityCardResponse blockSecurityCard(String cardId) {
		securityCardApplication.blockSecurityCard(CardId.of(cardId));
		return new BlockSecurityCardResponse("success");
	}

	public void printSecurityCard(PrintSecurityCardMessage message) {
		SecurityCard securityCard = modelMapper.map(message,SecurityCard.class);
		securityCardApplication.printSecurityCard(securityCard );
	}

}
