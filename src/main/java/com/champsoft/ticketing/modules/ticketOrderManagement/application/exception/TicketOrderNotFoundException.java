package com.champsoft.ticketing.modules.ticketOrderManagement.application.exception;

public class TicketOrderNotFoundException extends RuntimeException {

    public TicketOrderNotFoundException(String message) {
        super(message);
    }
}