package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.AlternativeFeedbackDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.FeedbackDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionFeedbackDTO;
import com.nexus.nexusrpg.domain.mapper.feedback.AlternativeFeedbackMapper;
import com.nexus.nexusrpg.domain.mapper.feedback.QuestionFeedbackMapper;
import com.nexus.nexusrpg.domain.model.relation.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponseMapper implements Mapper<Response, FeedbackDTO> {

    private final QuestionFeedbackMapper questionFeedbackMapper;
    private final AlternativeFeedbackMapper alternativeFeedbackMapper;

    @Override
    public FeedbackDTO map(Response response) {
        boolean hit = response.isHit();
        return new FeedbackDTO(
                mapQuestion(response),
                mapUserAlternative(response),
                hit ? null : mapCorrectAlternative(response),
                hit
        );
    }

    private AlternativeFeedbackDTO mapUserAlternative(Response response) {
        var alternative = response.getAlternative();
        return alternativeFeedbackMapper.map(alternative);
    }

    private AlternativeFeedbackDTO mapCorrectAlternative(Response response) {
        var alternative = response.getQuestion().getCorrect();
        return alternativeFeedbackMapper.map(alternative);
    }

    private QuestionFeedbackDTO mapQuestion(Response response) {
        var question = response.getQuestion();
        return questionFeedbackMapper.map(question);
    }
}
