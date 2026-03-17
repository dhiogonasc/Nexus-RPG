package com.nexus.nexusrpg.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDateTime;

@Tag(name = "User Stat DTO")
public record UserStatDTO(

        @Schema(description = "Identificador do Stat de usuário")
        Long id,

        @Schema(description = "Dados do usuário")
        UserDTO user,

        @Schema(description = "Nivel atual")
        LevelDTO level,

        @Schema(description = "Planeta atual")
        PlanetDTO currentPlanet,

        @Schema(description = "Missão atual")
        MissionDTO currentMission,

        @Schema(description = "XP atual do usuário")
        int xpTotal,

        @Schema(description = "Sequência de dias de acesso continuo")
        int streakCurrent,

        @Schema(description = "Último acesso do usuário")
        LocalDateTime lastAccess
) {}
