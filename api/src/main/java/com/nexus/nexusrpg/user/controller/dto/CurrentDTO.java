package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.MissionRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceRefDTO;

public record CurrentDTO(

        LevelReferenceDTO level,
        PlanetRefDTO planet,
        MissionRefDTO mission,
        ResourceRefDTO resource
) {
}
