package com.nexus.nexusrpg.controller.dto.mission;

import com.nexus.nexusrpg.controller.dto.planet.PlanetReferenceDTO;
import com.nexus.nexusrpg.controller.dto.question.QuestionDTO;
import com.nexus.nexusrpg.model.entity.Question;
import com.nexus.nexusrpg.model.enums.MissionDifficulty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

import java.util.List;

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
        PlanetReferenceDTO planet,

        @Schema(description = "Questões da missão")
        List<QuestionDTO> questions
){}
