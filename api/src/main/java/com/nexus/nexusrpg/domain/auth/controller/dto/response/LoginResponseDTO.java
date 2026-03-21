package com.nexus.nexusrpg.domain.auth.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.Instant;

@Tag(name = "Login Response DTO", description = "Token de acesso")
public record LoginResponseDTO (

        @Schema(description = "Token de acesso")
        String token,

        @Schema(description = "Tempo de expiração de token de acesso")
        Long expiresIn,

        @Schema(description = "Data e hora de login")
        Instant loggedInAt
) {
}
