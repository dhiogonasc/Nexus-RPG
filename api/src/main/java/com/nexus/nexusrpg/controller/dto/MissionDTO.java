package com.nexus.nexusrpg.controller.dto;

import com.nexus.nexusrpg.model.enums.DifficultyLevel;
import io.swagger.v3.oas.annotations.media.Schema;

public record MissionDTO(

        @Schema(description = "Identificador da Missão")
        Long id,

        @Schema(description = "Identificador do Planeta de vinculo")
        Long planetId,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Descrição")
        String description,

        @Schema(description = "Ordem de acesso")
        int order,

        @Schema(description = "Dificuldade")
        DifficultyLevel difficulty,

        @Schema(description = "XP ganho ao concluir")
        int xpReward
){}
