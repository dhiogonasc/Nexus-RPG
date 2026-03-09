package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDateTime;


@Tag(name = "Usuário Response DTO", description = "Campos de resposta")
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
