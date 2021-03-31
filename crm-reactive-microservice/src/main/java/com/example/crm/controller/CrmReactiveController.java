package com.example.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.document.CustomerDocument;
import com.example.crm.service.CustomerReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customers")
public class CrmReactiveController {
	@Autowired
	private CustomerReactiveService customerService;

	@GetMapping("{identity}")
	public Mono<CustomerDocument> getCustomerByIdentity(@PathVariable String identity) {
		return customerService.getByIdentity(identity);
	}

	@GetMapping(params = { "page", "size" })
	public Flux<CustomerDocument> getCustomersByPage(@RequestParam int page, @RequestParam int size) {
		return customerService.getCustomers(page, size);
	}

	@PostMapping
	public Mono<CustomerDocument> acquireCustomer(@RequestBody CustomerDocument customer) {
		System.err.println(customer);
		return customerService.addCustomer(customer);
	}
	
	@PutMapping
	public Mono<CustomerDocument> updateCustomer(@RequestBody CustomerDocument customer) {
		return customerService.updateCustomer(customer);
	}

	
}
