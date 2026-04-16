package com.nexus.nexusrpg.domain.user.controller.dto;

import com.nexus.nexusrpg.domain.entity.level.mapper.dto.LevelDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceReferenceDTO;

public record CurrentDTO(

        LevelDTO level,
        UserPlanetReferenceDTO planet,
        UserMissionReferenceDTO mission,
        UserResourceReferenceDTO resource
) {
}
