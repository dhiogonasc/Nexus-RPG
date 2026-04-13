package com.nexus.nexusrpg.domain.question.controller.dto;

import java.util.List;

public record QuestionDTO(

        Long id,
        String description,
        String codeSnippet,
        Integer order,
        List<AlternativeDTO> alternatives
) {
}