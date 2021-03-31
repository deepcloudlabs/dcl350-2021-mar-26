package com.example.crm.service;

import com.example.crm.document.CustomerDocument;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerReactiveService {

	Mono<CustomerDocument> getByIdentity(String identity);

	Flux<CustomerDocument> getCustomers(int page, int size);

	Mono<CustomerDocument> addCustomer(CustomerDocument customer);

	Mono<CustomerDocument> updateCustomer(CustomerDocument customer);

	Mono<CustomerDocument> removeByIdentity(String identity);

}
