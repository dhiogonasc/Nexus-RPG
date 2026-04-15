package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.domain.entity.mission.model.enums.MissionDifficulty;

public record MissionReferenceDTO(

        Long id,
        String name,
        int order,
        MissionDifficulty difficulty
){}
