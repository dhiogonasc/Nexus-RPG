package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.feedback.Feedback;
import com.nexus.nexusrpg.domain.model.relation.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponseMapper implements Mapper<Response, Feedback> {

    private final FeedbackMapper feedbackMapper;

    @Override
    public Feedback map(Response response) {
        boolean hit = response.isHit();
        return new Feedback(
                feedbackMapper.map(response.getQuestion()),
                feedbackMapper.map(response.getAlternative()),
                hit ? null : feedbackMapper.map(response.getCorrect()),
                hit,
                response.getFeedback()
        );
    }
}
