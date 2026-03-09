package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(

        @Schema(name = "Id", description = "Identificador do usuário")
        Long id,

        @Schema(name = "Nome", description = "Nome de usuário")
        String nome,

        @Schema(name = "Email", description = "Endereço de email do usuário")
        String email,

        @Schema(name = "Data de criação", description = "Data e hora de cadastro do usuário")
        LocalDateTime dataCriacao
) {}
