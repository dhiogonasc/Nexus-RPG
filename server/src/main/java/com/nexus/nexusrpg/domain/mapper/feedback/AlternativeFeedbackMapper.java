package com.nexus.nexusrpg.domain.mapper.feedback;

import com.nexus.nexusrpg.domain.controller.dto.response.AlternativeFeedbackDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionFeedbackDTO;
import com.nexus.nexusrpg.domain.model.Alternative;
import com.nexus.nexusrpg.domain.model.Question;
import org.springframework.stereotype.Component;

@Component
public class AlternativeFeedbackMapper extends FeedbackMapper<Alternative, AlternativeFeedbackDTO>{
    @Override
    public AlternativeFeedbackDTO map(Alternative alternative) {
        return new AlternativeFeedbackDTO(
                alternative.getId(),
                alternative.getContent(),
                alternative.getIsCorrect()
        );
    }
}
