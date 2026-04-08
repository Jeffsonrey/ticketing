package com.champsoft.ticketing.modules.event.api.dto;

public record EventEligibilityResponse(
        String eventId,
        boolean eligible
) {}