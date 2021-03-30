package com.example.card.infrastructure;

import com.example.card.event.SecurityCardEvent;

public interface EventPublisher {

	void publishEvent(SecurityCardEvent event);

}
