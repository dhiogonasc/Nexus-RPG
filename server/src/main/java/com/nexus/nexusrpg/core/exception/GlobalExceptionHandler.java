package com.nexus.nexusrpg.core.exception;

import com.nexus.nexusrpg.core.exception.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorDTO>> handleBusinessException(BusinessException ex) {

        List<ErrorDTO> errorDetails = List.of(
                new ErrorDTO(
                        ex.getField(),
                        ex.getMessage(),
                        ex.getStatus()
                )
        );

        return ResponseEntity.status(ex.getStatus()).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> handleValidationErrors(MethodArgumentNotValidException ex) {

        List<ErrorDTO> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> new ErrorDTO(f.getField(), f.getDefaultMessage(), BAD_REQUEST))
                .toList();

        return ResponseEntity.status(BAD_REQUEST).body(errors);
    }
}