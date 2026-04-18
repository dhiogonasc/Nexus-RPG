package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.MissionRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetRefDTO;

public record CurrentDTO(

        LevelRefDTO level,
        PlanetRefDTO planet,
        MissionRefDTO mission
) {
}
