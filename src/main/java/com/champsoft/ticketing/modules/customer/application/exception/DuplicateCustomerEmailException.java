package com.champsoft.ticketing.modules.customer.application.exception;

public class DuplicateCustomerEmailException extends RuntimeException {

    public DuplicateCustomerEmailException(String message) {
        super(message);
    }
}