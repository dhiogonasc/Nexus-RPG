package com.nexus.nexusrpg.core.exception.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorDTO(
        String field,
        String error,
        HttpStatus status,
        LocalDateTime timestamp
) {}