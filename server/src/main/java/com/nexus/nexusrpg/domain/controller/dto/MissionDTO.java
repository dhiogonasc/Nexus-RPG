package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.common.task.ExecutionDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionDTO;

import java.math.BigDecimal;
import java.util.List;

public record MissionDTO(
        Long id,
        String name,
        String description,
        long xpBonus,
        EntityReferenceDTO planet,
        List<QuestionDTO> questions,
        ExecutionDTO execution,
        BigDecimal bestResult,
        int order
) {}