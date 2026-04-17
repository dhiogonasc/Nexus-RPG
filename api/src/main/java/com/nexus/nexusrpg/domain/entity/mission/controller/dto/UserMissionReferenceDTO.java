package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetStatsReferenceDTO;

public record UserMissionReferenceDTO(

        MissionReferenceDTO mission,
        UserPlanetStatsReferenceDTO stats
) {}