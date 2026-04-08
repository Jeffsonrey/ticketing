package com.champsoft.ticketing.modules.event.application.service;

import com.champsoft.ticketing.modules.event.application.exception.EventNotFoundException;
import com.champsoft.ticketing.modules.event.application.port.out.EventRepositoryPort;
import com.champsoft.ticketing.modules.event.domain.model.EventId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventEligibilityService {

    private final EventRepositoryPort repo;

    public EventEligibilityService(EventRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public boolean isEligible(String eventId) {
        return repo.findById(EventId.of(eventId))
                .map(event -> event.isEligibleForTicketing())
                .orElseThrow(() -> new EventNotFoundException("Event not found: " + eventId));
    }
}