package com.nexus.nexusrpg.domain.entity.question;

import java.util.List;

public record QuestionDTO(
        Long id,
        String name,
        String description,
        String codeSnippet,
        List<AlternativeDTO> alternatives
) {
}