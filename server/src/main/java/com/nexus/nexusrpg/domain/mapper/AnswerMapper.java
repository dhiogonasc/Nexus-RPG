package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AnswerDTO;
import com.nexus.nexusrpg.domain.model.relation.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerMapper implements Mapper<Answer, AnswerDTO> {

    private final FeedbackMapper feedbackMapper;

    @Override
    public AnswerDTO map(Answer answer) {
        boolean hit = answer.isHit();
        return new AnswerDTO(
                answer.getQuestion().getOrder(),
                feedbackMapper.map(answer.getQuestion()),
                feedbackMapper.map(answer.getAlternative()),
                hit ? null : feedbackMapper.map(answer.getCorrect()),
                hit,
                answer.getExplanation()
        );
    }
}
