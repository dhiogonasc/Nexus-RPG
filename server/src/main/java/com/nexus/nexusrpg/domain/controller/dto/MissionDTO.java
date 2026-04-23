package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.task.ExecutionDTO;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.entity.question.QuestionDTO;

import java.util.List;

public record MissionDTO(
        Long id,
        String name,
        String description,
        long xpBonus,
        List<QuestionDTO> questions,
        EntityReferenceDTO planet,
        ExecutionDTO execution
) {}