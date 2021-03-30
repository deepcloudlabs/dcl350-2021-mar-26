package com.example.card.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.card.document.SecurityCardDocument;

public interface SecurityCardDocumentRepository extends MongoRepository<SecurityCardDocument, String>{
	   List<SecurityCardDocument> findByLastName(String lastName);
	   @Query("{lastName: ?0}")
	   List<SecurityCardDocument> soyadaGoreGetir(String lastName);
}
