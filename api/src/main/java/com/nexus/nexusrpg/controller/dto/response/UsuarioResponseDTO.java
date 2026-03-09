package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(

        @Schema(description = "Identificador do usuário")
        Long id,

        @Schema(description = "Nome de usuário")
        String nome,

        @Schema(description = "Endereço de email do usuário")
        String email,

        @Schema(description = "Data e hora de cadastro do usuário")
        LocalDateTime dataCriacao
) {}
