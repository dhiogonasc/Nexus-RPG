package com.nexus.nexusrpg.domain.mission.controller.dto;

import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetReferenceDTO;
import com.nexus.nexusrpg.domain.mission.model.enums.MissionDifficulty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

public record MissionDTO(

        @Schema(description = "Identificador da Missão")
        Long id,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Descrição")
        String description,

        @Schema(description = "Ordem de acesso")
        @Positive
        int order,

        @Schema(description = "Dificuldade")
        MissionDifficulty difficulty,

        @Schema(description = "XP ganho ao concluir")
        long xpBonus,

        @Schema(description = "Referencia do planeta de origem")
        PlanetReferenceDTO planet
){}
