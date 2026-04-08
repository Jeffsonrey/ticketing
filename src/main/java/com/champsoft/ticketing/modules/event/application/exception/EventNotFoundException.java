package com.champsoft.ticketing.modules.event.application.exception;



public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String message) {
        super(message);
    }
}