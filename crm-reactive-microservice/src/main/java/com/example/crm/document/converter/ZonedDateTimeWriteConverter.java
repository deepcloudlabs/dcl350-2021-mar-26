package com.example.crm.document.converter;

import java.time.ZonedDateTime;
import java.util.Date;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import com.mongodb.lang.Nullable;

@Component
@WritingConverter
public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Document> {
	static final String DATE_TIME = "dateTime";
	static final String ZONE = "zone";

	@Override
	public Document convert(@Nullable ZonedDateTime zonedDateTime) {
		if (zonedDateTime == null)
			return null;

		Document document = new Document();
		document.put(DATE_TIME, Date.from(zonedDateTime.toInstant()));
		document.put(ZONE, zonedDateTime.getZone().getId());
		document.put("offset", zonedDateTime.getOffset().toString());
		return document;
	}
}
