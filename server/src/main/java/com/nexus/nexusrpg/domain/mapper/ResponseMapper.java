package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.AlternativeFeedbackDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionFeedbackDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.ResponseDTO;
import com.nexus.nexusrpg.domain.mapper.feedback.AlternativeFeedbackMapper;
import com.nexus.nexusrpg.domain.mapper.feedback.QuestionFeedbackMapper;
import com.nexus.nexusrpg.domain.model.relation.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponseMapper implements Mapper<Response, ResponseDTO> {

    private final QuestionFeedbackMapper questionFeedbackMapper;
    private final AlternativeFeedbackMapper alternativeFeedbackMapper;

    @Override
    public ResponseDTO map(Response response) {
        return new ResponseDTO(
                mapQuestion(response),
                mapAlternative(response),
                response.isHit()
        );
    }

    private AlternativeFeedbackDTO mapAlternative(Response response) {
        var alternative = response.getAlternative();
        return alternativeFeedbackMapper.map(alternative);
    }

    private QuestionFeedbackDTO mapQuestion(Response response) {
        var question = response.getQuestion();
        return questionFeedbackMapper.map(question);
    }
}
