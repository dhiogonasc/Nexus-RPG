package com.nexus.nexusrpg.domain.controller.dto.response;

public record QuestionFeedbackDTO(
        Long id,
        String content,
        String feedback
) {
}
