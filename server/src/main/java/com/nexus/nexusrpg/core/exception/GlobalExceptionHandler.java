package com.nexus.nexusrpg.core.exception;

import com.nexus.nexusrpg.core.exception.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDTO> handleBusinessException(BusinessException ex) {

                var error = new ErrorDTO(
                        ex.getField(),
                        ex.getMessage(),
                        ex.getStatus(),
                        LocalDateTime.now()
                );

        return ResponseEntity.status(ex.getStatus()).body(error);
    }
}