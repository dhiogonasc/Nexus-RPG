package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.feedback.AnswerComponent;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AnswerComponentDTO;
import org.springframework.stereotype.Component;

@Component
public class AnswerComponentMapper implements Mapper<AnswerComponent, AnswerComponentDTO>{

    @Override
    public AnswerComponentDTO map(AnswerComponent item) {
        return new AnswerComponentDTO(
                item.getId(),
                item.getContent()
        );
    }
}
