package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionFeedbackDTO;
import com.nexus.nexusrpg.domain.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper implements Mapper<Question, QuestionFeedbackDTO> {

    @Override
    public QuestionFeedbackDTO toDTO(Question question) {
        return new QuestionFeedbackDTO(
                question.getId(),
                question.getContent(),
                question.getFeedback()
        );
    }
}
