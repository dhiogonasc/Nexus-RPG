package com.nexus.nexusrpg.controller.dto.global.question;

public record AlternativeDTO(

        Long id,
        String content,
        String feedbackTip,
        Boolean isCorrect
) {
}