package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.feedback.FeedbackItem;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AnswerComponentDTO;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper implements Mapper<FeedbackItem, AnswerComponentDTO>{

    @Override
    public AnswerComponentDTO map(FeedbackItem item) {
        return new AnswerComponentDTO(
                item.getId(),
                item.getContent()
        );
    }
}
