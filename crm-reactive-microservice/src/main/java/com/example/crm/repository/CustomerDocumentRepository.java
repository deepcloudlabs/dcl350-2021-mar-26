package com.example.crm.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.crm.document.CustomerDocument;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerDocumentRepository extends ReactiveMongoRepository<CustomerDocument, String> {
	@Query("{year: { $gt: ?0, $lt: ?1}}")
	Flux<CustomerDocument> yasaGoreGetir(int fromYear, int toYear);

	Flux<CustomerDocument> findAllByBirthYearBetween(int fromYear, int toYear);

	Flux<CustomerDocument> findAllByCountryCodeAndCity(String country, String city);

	Mono<CustomerDocument> findByEmail(String email);

	@Query("{}")
	Flux<CustomerDocument> findAll(Pageable page);
}
