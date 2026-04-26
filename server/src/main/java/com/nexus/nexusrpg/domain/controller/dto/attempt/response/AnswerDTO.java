package com.nexus.nexusrpg.domain.controller.dto.attempt.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AnswerDTO(
        int order,
        AnswerComponentDTO question,
        AnswerComponentDTO selection,
        AnswerComponentDTO correct,
        boolean hit,
        String explanation
) {}
