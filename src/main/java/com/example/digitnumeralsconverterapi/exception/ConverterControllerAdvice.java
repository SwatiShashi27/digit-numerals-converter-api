package com.example.digitnumeralsconverterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConverterControllerAdvice {
    @ExceptionHandler(value = ConvertedNumberFormatException.class)
    public ResponseEntity<Object> exception(ConvertedNumberFormatException exception) {
        return new ResponseEntity<>("Invalid roman number value!", HttpStatus.BAD_REQUEST);
    }
}
