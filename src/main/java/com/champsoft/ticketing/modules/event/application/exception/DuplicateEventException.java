package com.champsoft.ticketing.modules.event.application.exception;

public class DuplicateEventException extends RuntimeException {
  public DuplicateEventException(String message) {
    super(message);
  }
}
