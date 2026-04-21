package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

public record ProgressionDTO(
        LevelDTO level,
        UPlanetDTOR planet,
        UMissionDTOR mission
) {
}
