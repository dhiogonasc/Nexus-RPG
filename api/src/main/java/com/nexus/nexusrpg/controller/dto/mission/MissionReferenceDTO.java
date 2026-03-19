package com.nexus.nexusrpg.controller.dto.mission;

import com.nexus.nexusrpg.model.enums.MissionDifficulty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

public record MissionReferenceDTO(

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
        MissionDifficulty difficulty
){}
