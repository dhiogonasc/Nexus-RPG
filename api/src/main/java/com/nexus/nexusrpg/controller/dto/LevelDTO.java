package com.nexus.nexusrpg.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Level DTO")
public record LevelDTO(

        @Schema(description = "Identificador do level")
        Long id,

        @Schema(description = "Número correspondente")
        int number,

        @Schema(description = "XP necessário para o level")
        int xpRequired
) {}
