package com.nexus.nexusrpg.exception;

import com.nexus.nexusrpg.controller.dto.response.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponseDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<ErrorResponseDTO> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ErrorResponseDTO(
                        erro.getField(),
                        erro.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .badRequest()
                .body(erros);
    }
}