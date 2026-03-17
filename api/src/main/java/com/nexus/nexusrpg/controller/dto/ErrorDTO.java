package com.nexus.nexusrpg.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

public record ErrorDTO(

        @Schema(description = "Campo de erro")
        String field,

        @Schema(description = "Descrição")
        String error,

        @Schema(description = "Status http de erro")
        HttpStatus status
) {}