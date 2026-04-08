package com.champsoft.ticketing.modules.event.api.mapper;

import com.champsoft.ticketing.modules.event.api.dto.EventResponse;
import com.champsoft.ticketing.modules.event.domain.model.EventListing;

public class EventApiMapper {
    public static EventResponse toResponse(EventListing event){
        return new EventResponse(
                event.getId().value(),
                event.getTitle(),
                event.getDescription(),
                event.getVenue().getName(),
                event.getVenue().getAddress(),
                event.getVenue().getCity(),
                event.getSchedule().startDateTime(),
                event.getSchedule().endDateTime(),
                event.getTotalCapacity(),
                event.getAvailableTickets(),
                event.getStatus().name()
        );
    }
}
