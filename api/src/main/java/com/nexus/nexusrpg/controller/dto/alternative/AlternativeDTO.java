package com.nexus.nexusrpg.controller.dto.alternative;

public record AlternativeDTO(

        Long id,
        String content,
        String feedbackTip,
        Boolean isCorrect
) {
}