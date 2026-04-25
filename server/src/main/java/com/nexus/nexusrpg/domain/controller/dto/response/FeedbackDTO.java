package com.nexus.nexusrpg.domain.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FeedbackDTO(
        QuestionFeedbackDTO question,
        AlternativeFeedbackDTO userAlternative,
        AlternativeFeedbackDTO correctAlternative,
        boolean hit
) {}
