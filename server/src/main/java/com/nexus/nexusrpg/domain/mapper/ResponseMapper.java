package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.AlternativeFeedbackDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionFeedbackDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.ResponseDTO;
import com.nexus.nexusrpg.domain.model.relation.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponseMapper implements Mapper<Response, ResponseDTO> {

    private final QuestionMapper questionMapper;
    private final AlternativeMapper alternativeMapper;

    @Override
    public ResponseDTO toDTO(Response response) {
        return new ResponseDTO(
                mapQuestion(response),
                mapAlternative(response)
        );
    }

    private AlternativeFeedbackDTO mapAlternative(Response response) {
        var alternative = response.getAlternative();
        return alternativeMapper.toDTO(alternative);
    }

    private QuestionFeedbackDTO mapQuestion(Response response) {
        var question = response.getQuestion();
        return questionMapper.toDTO(question);
    }
}
