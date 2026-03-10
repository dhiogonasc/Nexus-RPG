package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDateTime;

@Tag(name = "Register Response DTO", description = "Campos de resposta para cadastro realizado")
public record RegisterResponseDTO(

        @Schema(description = "Identificador do usuário")
        Long id,

        @Schema(description = "Nome de usuário")
        String username,

        @Schema(description = "Endereço de email do usuário")
        String email,

        @Schema(description = "Data e hora de cadastro do usuário")
        LocalDateTime createdAt
) {}
