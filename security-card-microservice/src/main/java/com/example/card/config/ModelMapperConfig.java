package com.example.card.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.card.document.SecurityCardDocument;
import com.example.card.domain.CardId;
import com.example.card.domain.SecurityCard;
import com.example.card.message.PrintSecurityCardMessage;

@Configuration
public class ModelMapperConfig {
			
	private static final Converter<SecurityCard,SecurityCardDocument> securityCard2SecurityCardDocumentConverter = 
			context -> {
				var securityCard = context.getSource();
				var securityCardDocument = new SecurityCardDocument();
				securityCardDocument.setCardId(securityCard.getCardId().getValue());
				securityCardDocument.setPhoto(new String(securityCard.getPhoto().getData()));
				securityCardDocument.setFirstName(securityCard.getFullname().getFirstName());
				securityCardDocument.setLastName(securityCard.getFullname().getLastName());
				return securityCardDocument;
			};
			
	private static final Converter<SecurityCardDocument,SecurityCard> securityCardDocument2SecurityCardConverter = 
			context -> {
				var securityCardDocument = context.getSource();
				var securityCard = new SecurityCard.Builder(CardId.of(securityCardDocument.getCardId()))
						      .fullname(securityCardDocument.getFirstName(), securityCardDocument.getLastName())
				              .photo(securityCardDocument.getPhoto().getBytes())
				              .build();
				return securityCard;
			};
	
	private static final Converter<PrintSecurityCardMessage,SecurityCard> printSecurityCardMessage2SecurityCardConverter = 
			context -> {
				var securityCardMessage = context.getSource();
				var securityCard = new SecurityCard.Builder(CardId.of(securityCardMessage.getCardId()))
						.fullname(securityCardMessage.getFirstName(), securityCardMessage.getLastName())
						.photo(securityCardMessage.getPhoto().getBytes())
						.build();
				return securityCard;
			};
			
	@Bean
	public ModelMapper mapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(securityCard2SecurityCardDocumentConverter,SecurityCard.class,SecurityCardDocument.class);
		modelMapper.addConverter(securityCardDocument2SecurityCardConverter,SecurityCardDocument.class,SecurityCard.class);
		modelMapper.addConverter(printSecurityCardMessage2SecurityCardConverter,PrintSecurityCardMessage.class,SecurityCard.class);
		return modelMapper;
	}
}
