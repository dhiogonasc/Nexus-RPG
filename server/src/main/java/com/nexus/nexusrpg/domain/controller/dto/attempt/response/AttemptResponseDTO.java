package com.nexus.nexusrpg.domain.controller.dto.attempt.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nexus.nexusrpg.common.dto.EntityDynamicReference;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record AttemptResponseDTO(
        Long id,
        LocalDateTime startAt,
        LocalDateTime endAt,
        List<AnswerDTO> answers,
        EntityDynamicReference mission,
        BigDecimal result
) {
}
