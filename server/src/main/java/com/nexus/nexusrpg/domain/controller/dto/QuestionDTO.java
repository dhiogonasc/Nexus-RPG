package com.nexus.nexusrpg.domain.controller.dto;

import java.util.List;

public record QuestionDTO(
        Long id,
        String content,
        int order,
        List<AlternativeDTO> alternatives
) {
}
