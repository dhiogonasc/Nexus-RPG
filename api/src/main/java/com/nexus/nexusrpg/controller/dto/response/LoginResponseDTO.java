package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDateTime;

@Tag(name = "Login Response DTO", description = "Token de acesso")
public record LoginResponseDTO (

        @Schema(description = "Token de acesso")
        String token,

        @Schema(description = "Data e hora de login")
        LocalDateTime loggedInAt
) {
}
