package com.nexus.nexusrpg.controller.dto.question;

import com.nexus.nexusrpg.controller.dto.alternative.AlternativeDTO;

import java.util.List;

public record QuestionDTO(

        Long id,
        String description,
        String codeSnippet,
        Integer order,
        List<AlternativeDTO> alternatives
) {
}