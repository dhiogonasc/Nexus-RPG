package com.nexus.nexusrpg.controller.dto.global.question;

import java.util.List;

public record QuestionDTO(

        Long id,
        String description,
        String codeSnippet,
        Integer order,
        List<AlternativeDTO> alternatives
) {
}