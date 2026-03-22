package com.nexus.nexusrpg.controller.dto.planet;

import io.swagger.v3.oas.annotations.media.Schema;

public record PlanetReferenceDTO(

        @Schema(description = "Identificador do Planeta")
        Long id,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Ordem de acesso")
        int order
) {}
