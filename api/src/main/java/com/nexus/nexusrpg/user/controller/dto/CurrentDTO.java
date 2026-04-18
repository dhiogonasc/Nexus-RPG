package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.LevelReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.MissionRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.ResourceRefDTO;

public record CurrentDTO(

        LevelReferenceDTO level,
        PlanetRefDTO planet,
        MissionRefDTO mission,
        ResourceRefDTO resource
) {
}
