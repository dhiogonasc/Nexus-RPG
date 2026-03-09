package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Login Response DTO", description = "Token de acesso")
public record LoginResponseDTO (

        @Schema(description = "Código de acesso")
        String token
) {
}
