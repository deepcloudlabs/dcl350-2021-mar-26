package com.example.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.card.dto.BlockSecurityCardResponse;
import com.example.card.service.SecurityCardService;

@RestController
@RequestMapping("cards")
@RequestScope
@CrossOrigin
public class SecurityCardRestController {
	@Autowired
	private SecurityCardService securityCardService;
	
	@DeleteMapping("{id}")
	public BlockSecurityCardResponse blockSecurityCard(@PathVariable String id) {
		return securityCardService.blockSecurityCard(id);
	}
}
