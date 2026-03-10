package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Error Response DTO")
public record ErrorResponseDTO(

        @Schema(description = "Nome do campo inváido")
        String field,

        @Schema(description = "Especificação do erro")
        String message
) {}
