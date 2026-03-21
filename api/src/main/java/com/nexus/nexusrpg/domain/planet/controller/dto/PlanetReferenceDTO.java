package com.nexus.nexusrpg.domain.planet.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record PlanetReferenceDTO(

        @Schema(description = "Identificador do Planeta")
        Long id,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Ordem de acesso")
        int order
) {}
