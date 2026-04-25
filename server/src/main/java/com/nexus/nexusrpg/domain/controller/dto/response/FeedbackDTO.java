package com.nexus.nexusrpg.domain.controller.dto.response;

public record FeedbackDTO(
        QuestionFeedbackDTO question,
        AlternativeFeedbackDTO alternative,
        boolean hit
) {}
