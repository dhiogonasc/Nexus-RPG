package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionRDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetRDTO;

public record UserProgressionDTO(
        LevelDTO level,
        UPlanetRDTO planet,
        UMissionRDTO mission
) {
}
