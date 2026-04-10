package com.champsoft.ticketing.modules.ticketOrderManagement.application.exception;

public class InvalidTicketOrderException extends RuntimeException {

    public InvalidTicketOrderException(String message) {
        super(message);
    }
}