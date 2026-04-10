package com.champsoft.ticketing.modules.ticketInventory.application.exception;

public class DuplicateTicketInventoryException extends RuntimeException {
    public DuplicateTicketInventoryException(String message) {
        super(message);
    }
}