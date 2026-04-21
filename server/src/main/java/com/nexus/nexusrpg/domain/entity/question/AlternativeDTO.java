package com.nexus.nexusrpg.domain.entity.question;

public record AlternativeDTO(
        Long id,
        Long questionId,
        String content,
        String feedbackTip,
        Boolean isCorrect
) {
}