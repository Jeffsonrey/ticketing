package com.champsoft.ticketing.modules.ticketOrderManagement.api.mapper;

import com.champsoft.ticketing.modules.ticketOrderManagement.api.dto.TicketOrderResponseModel;
import com.champsoft.ticketing.modules.ticketOrderManagement.model.TicketOrder;

public class TicketOrderResponseMapper {

    private TicketOrderResponseMapper() {
    }

    public static TicketOrderResponseModel toResponseModel(TicketOrder ticketOrder) {
        return new TicketOrderResponseModel(
                ticketOrder.getId(),
                ticketOrder.getOrderIdentifier(),
                ticketOrder.getCustomerId(),
                ticketOrder.getEventId(),
                ticketOrder.getTicketType(),
                ticketOrder.getQuantity(),
                ticketOrder.getTotalPrice(),
                ticketOrder.getStatus()
        );
    }
}