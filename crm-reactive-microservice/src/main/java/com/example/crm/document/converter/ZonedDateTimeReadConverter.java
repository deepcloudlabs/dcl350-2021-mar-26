package com.example.crm.document.converter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import com.mongodb.lang.Nullable;

@Component
@ReadingConverter
public class ZonedDateTimeReadConverter implements Converter<Document, ZonedDateTime> {
	static final String DATE_TIME = "dateTime";
	static final String ZONE = "zone";

	@Override
	public ZonedDateTime convert(@Nullable Document document) {
		if (document == null)
			return null;

		Date dateTime = document.getDate(DATE_TIME);
		String zoneId = document.getString(ZONE);
		ZoneId zone = ZoneId.of(zoneId);

		return ZonedDateTime.ofInstant(dateTime.toInstant(), zone);
	}
}
