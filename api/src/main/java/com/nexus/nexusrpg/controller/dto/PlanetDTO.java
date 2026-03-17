package com.nexus.nexusrpg.controller.dto;

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

        @Schema(description = "Missões vinculadas ao planetas")
        List<MissionDTO> missions
) {}
