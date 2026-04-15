package com.nexus.nexusrpg.domain.mission.controller.dto;

import com.nexus.nexusrpg.domain.mission.model.enums.MissionDifficulty;

public record MissionReferenceDTO(

        Long id,
        String name,
        int order,
        MissionDifficulty difficulty
){}
