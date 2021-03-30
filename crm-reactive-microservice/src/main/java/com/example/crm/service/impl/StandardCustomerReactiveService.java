package com.example.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crm.document.CustomerDocument;
import com.example.crm.repository.CustomerDocumentRepository;
import com.example.crm.service.CustomerReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StandardCustomerReactiveService implements CustomerReactiveService {

	@Autowired
	private CustomerDocumentRepository custRepo;
	
	@Override
	public Mono<CustomerDocument> getByIdentity(String identity) {
		return custRepo.findById(identity);
	}

	@Override
	public Flux<CustomerDocument> getCustomers(int page, int size) {
		return custRepo.findAll(PageRequest.of(page, size));
	}

}
