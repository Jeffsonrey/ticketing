package com.champsoft.ticketing.modules.event.application.port.out;

import com.champsoft.ticketing.modules.event.domain.model.EventId;
import com.champsoft.ticketing.modules.event.domain.model.EventListing;

import java.util.List;
import java.util.Optional;

public interface EventRepositoryPort {
    EventListing save(EventListing event);
    Optional<EventListing> findById(EventId id);
    List<EventListing> findAll();
    void deleteById(EventId id);
}
