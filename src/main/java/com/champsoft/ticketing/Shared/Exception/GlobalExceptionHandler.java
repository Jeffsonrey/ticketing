package com.champsoft.ticketing.Shared.Exception;

import com.champsoft.ticketing.modules.customer.application.exception.CustomerNotFoundException;
import com.champsoft.ticketing.modules.customer.application.exception.DuplicateCustomerEmailException;
import com.champsoft.ticketing.modules.event.application.exception.EventNotFoundException;
import com.champsoft.ticketing.modules.ticketInventory.application.exception.InvalidTicketInventoryException;
import com.champsoft.ticketing.modules.ticketInventory.application.exception.TicketInventoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.champsoft.ticketing.modules.ticketInventory.application.exception.DuplicateTicketInventoryException;
import com.champsoft.ticketing.modules.ticketOrderManagement.application.exception.TicketOrderNotFoundException;
import com.champsoft.ticketing.modules.ticketOrderManagement.application.exception.InvalidTicketOrderException;
import com.champsoft.ticketing.modules.event.application.exception.DuplicateEventException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TicketOrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTicketOrderNotFound(TicketOrderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEvent(DuplicateEventException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage(), 409));
    }

    @ExceptionHandler(InvalidTicketOrderException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTicketOrder(InvalidTicketOrderException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400));
    }

    @ExceptionHandler(TicketInventoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTicketInventoryNotFound(TicketInventoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(DuplicateTicketInventoryException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateTicketInventory(DuplicateTicketInventoryException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage(), 409));
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEventNotFound(EventNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(DuplicateCustomerEmailException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateCustomerEmail(DuplicateCustomerEmailException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage(), 409));
    }

    @ExceptionHandler(InvalidTicketInventoryException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTicketInventory(InvalidTicketInventoryException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalState(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getDefaultMessage())
                .orElse("Validation failed");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(message, 400));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Unexpected error occurred", 500));
    }
}