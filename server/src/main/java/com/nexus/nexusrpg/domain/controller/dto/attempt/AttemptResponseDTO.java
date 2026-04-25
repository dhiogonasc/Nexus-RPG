package com.nexus.nexusrpg.domain.controller.dto.attempt;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.domain.controller.dto.response.ResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record AttemptResponseDTO(
        Long id,
        LocalDateTime startAt,
        LocalDateTime endAt,
        BigDecimal result,
        List<ResponseDTO> responses,
        EntityDynamicReference mission
) {
}
