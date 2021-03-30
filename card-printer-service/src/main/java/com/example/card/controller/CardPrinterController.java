package com.example.card.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.card.dto.CardInfo;

@RestController
@RequestMapping("cards")
@RequestScope
@CrossOrigin
public class CardPrinterController {

	@PostMapping
	public void print(@RequestBody CardInfo cardInfo) {
		System.err.println("Print card request is received.");
	}
}
