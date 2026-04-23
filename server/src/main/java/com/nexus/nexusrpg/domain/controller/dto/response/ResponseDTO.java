package com.nexus.nexusrpg.domain.controller.dto.response;

public record ResponseDTO(
        QuestionFeedbackDTO question,
        AlternativeFeedbackDTO alternative
) {}
