package com.nexus.nexusrpg.controller.dto.global.planet;

import com.nexus.nexusrpg.controller.dto.user.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.user.resource.UserResourceReferenceDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record PlanetDTO(

        @Schema(description = "Identificador do Planeta")
        Long id,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Descrição")
        String description,

        @Schema(description = "Ordem de acesso")
        int order,

        @Schema(description = "XP ganho ao concluir")
        long xpBonus,

        @Schema(description = "Missões vinculadas ao planetas")
        List<UserMissionReferenceDTO> missions,

        @Schema(description = "Recurso a coletar planetas")
        UserResourceReferenceDTO resource
) {}
