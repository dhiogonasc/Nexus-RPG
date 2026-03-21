package com.nexus.nexusrpg.controller.dto.user;

import com.nexus.nexusrpg.controller.dto.global.level.LevelDTO;
import com.nexus.nexusrpg.controller.dto.global.resource.CollectedResourcesDTO;
import com.nexus.nexusrpg.controller.dto.user.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.user.planet.UserPlanetReferenceDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

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
        UserPlanetReferenceDTO currentPlanet,

        @Schema(description = "Missão que o usuário se encontra no momento")
        UserMissionReferenceDTO currentMission,

        @Schema(description = "Recursos coletados")
        CollectedResourcesDTO collectedResources,

        @Schema(description = "Xp total do usuário")
        long xp,

        @Schema(description = "Quantidade de oxigênio disponível")
        int oxygen
) {
}
