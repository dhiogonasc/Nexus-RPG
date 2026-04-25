package com.nexus.nexusrpg.domain.mapper.feedback;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionFeedbackDTO;
import com.nexus.nexusrpg.domain.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionFeedbackMapper implements Mapper<Question, QuestionFeedbackDTO> {
    @Override
    public QuestionFeedbackDTO map(Question question) {
        return new QuestionFeedbackDTO(
                question.getId(),
                question.getContent(),
                question.getFeedback()
        );
    }
}
