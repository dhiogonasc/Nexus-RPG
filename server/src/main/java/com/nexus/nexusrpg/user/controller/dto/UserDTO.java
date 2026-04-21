package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

public record UserDTO(

        Long id,
        String username,
        String email,
        long xp,
        int oxygen,
        LevelDTO level,
        UPlanetDTOR currentPlanet,
        UMissionDTOR currentMission
) {
}
