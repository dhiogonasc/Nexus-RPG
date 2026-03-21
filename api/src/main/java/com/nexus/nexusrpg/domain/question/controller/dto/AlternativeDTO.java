package com.nexus.nexusrpg.domain.question.controller.dto;

public record AlternativeDTO(

        Long id,
        String content,
        String feedbackTip,
        Boolean isCorrect
) {
}