package com.nexus.nexusrpg.domain.controller.dto.mission;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;
import com.nexus.nexusrpg.domain.entity.question.QuestionDTO;

import java.util.List;

public record UMissionDTO(
        Long id,
        String name,
        String description,
        long xpBonus,
        List<QuestionDTO> questions,
        UPlanetDTOR planet,
        ExecutionDTO execution
) {}