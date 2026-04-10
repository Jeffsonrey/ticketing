package com.champsoft.ticketing.Shared.Exception;

import com.champsoft.ticketing.modules.ticketInventory.application.exception.InvalidTicketInventoryException;
import com.champsoft.ticketing.modules.ticketInventory.application.exception.TicketInventoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.champsoft.ticketing.modules.customer.application.exception.CustomerNotFoundException;
import com.champsoft.ticketing.modules.customer.application.exception.DuplicateCustomerEmailException;
import com.champsoft.ticketing.modules.event.application.exception.EventNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404
    @ExceptionHandler(TicketInventoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(TicketInventoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
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

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEventNotFound(EventNotFoundException ex) {
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
        ex.printStackTrace();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getClass().getSimpleName() + ": " + ex.getMessage(), 500));
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
}