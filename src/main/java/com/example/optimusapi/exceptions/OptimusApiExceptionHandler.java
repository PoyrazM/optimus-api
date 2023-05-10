package com.example.optimusapi.exceptions;

import com.example.optimusapi.dto.response.OptimusErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class OptimusApiExceptionHandler {

    private final LocalDateTime now = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final String formattedDateTime = now.format(formatter);

    @ExceptionHandler
    public ResponseEntity<OptimusErrorResponse> handleException(OptimusMemberNotFoundException exception) {

        OptimusErrorResponse errorResponse = OptimusErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .timeStamp(formattedDateTime)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OptimusErrorResponse> handleException(OptimusMemberNotDeletedException exception) {

        OptimusErrorResponse errorResponse = OptimusErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .timeStamp(formattedDateTime)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
