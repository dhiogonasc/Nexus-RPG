package com.nexus.nexusrpg.controller.dto;

import com.nexus.nexusrpg.model.enums.MissionDifficulty;
import io.swagger.v3.oas.annotations.media.Schema;

public record MissionDTO(

        @Schema(description = "Identificador da Missão")
        Long id,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Descrição")
        String description,

        @Schema(description = "Ordem de acesso")
        int order,

        @Schema(description = "Dificuldade")
        MissionDifficulty difficulty,

        @Schema(description = "XP ganho ao concluir")
        long xpBonus
){}
