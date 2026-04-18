package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

public record CurrentDTO(

        LevelRefDTO level,
        UPlanetDTOR planet,
        UMissionDTOR mission
) {
}
