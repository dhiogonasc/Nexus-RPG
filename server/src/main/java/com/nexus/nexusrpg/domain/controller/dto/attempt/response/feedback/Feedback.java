package com.nexus.nexusrpg.domain.controller.dto.attempt.response.feedback;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Feedback(
        FeedbackComponent question,
        FeedbackComponent selection,
        FeedbackComponent correct,
        boolean hit,
        String feedback
) {}
