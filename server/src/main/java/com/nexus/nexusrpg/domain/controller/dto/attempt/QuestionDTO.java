package com.nexus.nexusrpg.domain.controller.dto.attempt;

import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AnswerComponentDTO;

import java.util.List;

public record QuestionDTO(
        Long id,
        String content,
        int order,
        List<AnswerComponentDTO> alternatives
) {
}
