package com.example.card.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card.document.SecurityCardDocument;
import com.example.card.domain.CardId;
import com.example.card.domain.SecurityCard;
import com.example.card.repository.SecurityCardDocumentRepository;
import com.example.card.repository.SecurityCardRepository;

@Service
public class SecurityCardRepositoryMongoAdapter implements SecurityCardRepository {

	@Autowired
	private SecurityCardDocumentRepository repo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void save(SecurityCard securityCard) {
		var id = securityCard.getCardId().getValue();
		if (repo.existsById(id))
			throw new IllegalArgumentException("Card already exists");
		var securityCardDocument = modelMapper.map(securityCard, SecurityCardDocument.class);
		repo.save(securityCardDocument);

	}

	@Override
	public boolean exists(CardId cardId) {
		return repo.existsById(cardId.getValue());
	}

	@Override
	public SecurityCard removeByCardId(CardId cardId) {
		var id = cardId.getValue();
		var securityCardDocument = repo.findById(id);
		if (securityCardDocument.isEmpty())
			throw new IllegalArgumentException("Card does not exist");
		SecurityCardDocument document = securityCardDocument.get();
		repo.delete(document);
		return modelMapper.map(document, SecurityCard.class);
	}

}
