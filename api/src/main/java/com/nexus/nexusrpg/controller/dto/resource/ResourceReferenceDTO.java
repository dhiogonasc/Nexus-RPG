package com.nexus.nexusrpg.controller.dto.resource;

import io.swagger.v3.oas.annotations.media.Schema;

public record ResourceReferenceDTO(

        @Schema(description = "Identificador do Recurso")
        Long id,

        @Schema(description = "Nome")
        String name,

        @Schema(description = "Descrição")
        String description
){}
