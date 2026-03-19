package com.nexus.nexusrpg.controller.dto;

import com.nexus.nexusrpg.model.enums.LevelLabel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de transferência para dados de Nível/Patente")
public record LevelDTO(

        @Schema(description = "ID único do nível", example = "1")
        Long id,

        @Schema(description = "Nome técnico da patente", example = "IRON_II")
        LevelLabel name,

        @Schema(description = "Descrição da patente", example = "IRON_II")
        String description,

        @Schema(description = "Ordem hierárquica (1 a 12)", example = "5")
        int order,

        @Schema(description = "XP necessário para atingir este nível", example = "1250")
        long xpRequired
) {}
