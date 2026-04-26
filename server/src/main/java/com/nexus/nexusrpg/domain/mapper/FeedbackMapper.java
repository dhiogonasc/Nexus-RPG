package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.feedback.FeedbackItem;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.feedback.FeedbackComponent;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper implements Mapper<FeedbackItem, FeedbackComponent>{

    @Override
    public FeedbackComponent map(FeedbackItem item) {
        return new FeedbackComponent(
                item.getId(),
                item.getContent()
        );
    }
}
