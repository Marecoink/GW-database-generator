package com.marecoink.gw.database.station;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GWExceptionController {

    @ExceptionHandler(StationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStationNotFoundException(StationNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    static class ErrorResponse {
        private final int status;
        private final Date timestamp;
        private final String message;
        private final String details;

        public ErrorResponse(int status, Date timestamp, String message, String details) {
            this.status = status;
            this.timestamp = timestamp;
            this.message = message;
            this.details = details;
        }

        public int getStatus() {
            return status;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }
    }

    public static class StationNotFoundException extends RuntimeException {
        public StationNotFoundException(String message) {
            super(message);
        }
    }
}

