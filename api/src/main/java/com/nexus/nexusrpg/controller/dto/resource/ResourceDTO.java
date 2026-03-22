package com.nexus.nexusrpg.controller.dto.resource;

import com.nexus.nexusrpg.controller.dto.planet.PlanetReferenceDTO;
import io.swagger.v3.oas.annotations.media.Schema;

public record ResourceDTO(

        @Schema(description = "Identificador do Recurso")
        Long id,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Descrição")
        String description,

        @Schema(description = "XP ganho ao concluir")
        long xpBonus,

        @Schema(description = "Referencia do planeta de origem")
        PlanetReferenceDTO planet
) {
}
