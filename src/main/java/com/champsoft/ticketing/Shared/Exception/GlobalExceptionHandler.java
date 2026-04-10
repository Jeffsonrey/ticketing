package com.champsoft.ticketing.Shared.Exception;

import com.champsoft.ticketing.modules.ticketInventory.application.exception.InvalidTicketInventoryException;
import com.champsoft.ticketing.modules.ticketInventory.application.exception.TicketInventoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.champsoft.ticketing.modules.customer.application.exception.CustomerNotFoundException;
import com.champsoft.ticketing.modules.customer.application.exception.DuplicateCustomerEmailException;
import com.champsoft.ticketing.modules.ticketOrderManagement.application.exception.InvalidTicketOrderException;
import com.champsoft.ticketing.modules.ticketOrderManagement.application.exception.TicketOrderNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404
    @ExceptionHandler(TicketInventoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(TicketInventoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    // 400
    @ExceptionHandler(InvalidTicketInventoryException.class)
    public ResponseEntity<ErrorResponse> handleInvalid(InvalidTicketInventoryException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400));
    }

    // fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Unexpected error occurred", 500));
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(DuplicateCustomerEmailException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateCustomerEmail(DuplicateCustomerEmailException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage(), 409));
    }

    @ExceptionHandler(TicketOrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTicketOrderNotFound(TicketOrderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(InvalidTicketOrderException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTicketOrder(InvalidTicketOrderException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400));
    }
}