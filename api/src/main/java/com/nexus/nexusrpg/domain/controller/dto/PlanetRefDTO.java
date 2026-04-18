package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

public record PlanetRefDTO(

        Long id,
        PlanetLabel name,

        UPExecutionRefDTO execution
) {}