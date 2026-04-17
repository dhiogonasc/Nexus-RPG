package com.nexus.nexusrpg.domain.user.controller.dto;

import com.nexus.nexusrpg.domain.entity.level.mapper.dto.LevelReferenceDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionRefDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceRefDTO;

public record CurrentDTO(

        LevelReferenceDTO level,
        UserPlanetReferenceDTO planet,
        UserMissionRefDTO mission,
        UserResourceRefDTO resource
) {
}
