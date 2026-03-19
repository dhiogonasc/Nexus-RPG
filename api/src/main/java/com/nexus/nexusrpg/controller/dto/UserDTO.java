package com.nexus.nexusrpg.controller.dto;

import com.nexus.nexusrpg.controller.dto.mission.MissionDTO;
import com.nexus.nexusrpg.controller.dto.planet.PlanetDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "User DTO")
public record UserDTO(

        @Schema(description = "Identificador do usuário")
        Long id,

        @Schema(description = "Nome de usuário")
        String username,

        @Schema(description = "Endereço de email")
        String email,

        @Schema(description = "Nível atual")
        LevelDTO level,

        @Schema(description = "Planeta onde o usuário se encontra no momento")
        PlanetDTO currentPlanet,

        @Schema(description = "Lista de planetas já visitados/desbloqueados")
        List<UserPlanetDTO> unlockedPlanets,

        @Schema(description = "Missão que o usuário se encontra no momento")
        MissionDTO currentMission,

        @Schema(description = "Lista de missões já visitados/desbloqueados")
        List<UserMissionDTO> unlockedMissions,

        @Schema(description = "Xp total do usuário")
        long xp,

        @Schema(description = "Quantidade de oxigênio disponível")
        int oxygen
) {
}
