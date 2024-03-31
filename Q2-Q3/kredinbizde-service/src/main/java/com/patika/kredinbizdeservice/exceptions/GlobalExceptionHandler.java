package com.patika.kredinbizdeservice.exceptions;

import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.exceptions.dto.ExceptionResponse;
import com.patika.kredinbizdeservice.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    private LogService logService;


    @ExceptionHandler(KredinbizdeException.class)
    public ResponseEntity<ExceptionResponse> handleKredinbizdeException(KredinbizdeException exception) {
        logErrorAndSendToKafka(exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(prepareExceptionResponse(exception, HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllException(Exception exception) {
        logErrorAndSendToKafka(exception);
        logService.logError(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(prepareExceptionResponse(exception, HttpStatus.BAD_REQUEST));
    }

    public void logErrorAndSendToKafka(Exception exception) {
        String logMessage = String.format("exception occurred. Cause: %s, Message: %s",
                exception.getCause(), exception.getMessage());
        log.error(logMessage);
        logService.logError(logMessage);
    }

    private ExceptionResponse prepareExceptionResponse(Exception exception, HttpStatus httpStatus) {
        return ExceptionResponse.builder()
                .message(exception.getMessage())
                .httpStatus(httpStatus)
                .build();
    }

}
