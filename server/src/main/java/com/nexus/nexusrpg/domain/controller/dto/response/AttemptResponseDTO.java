package com.nexus.nexusrpg.domain.controller.dto.response;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record AttemptResponseDTO(
        Long id,
        LocalDateTime startAt,
        LocalDateTime endAt,
        BigDecimal result,
        List<FeedbackDTO> feedbacks,
        EntityDynamicReference mission
) {
}
