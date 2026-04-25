package com.nexus.nexusrpg.domain.mapper.feedback;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.AlternativeFeedbackDTO;
import com.nexus.nexusrpg.domain.model.Alternative;
import org.springframework.stereotype.Component;

@Component
public class AlternativeFeedbackMapper implements Mapper<Alternative, AlternativeFeedbackDTO> {
    @Override
    public AlternativeFeedbackDTO map(Alternative alternative) {
        return new AlternativeFeedbackDTO(
                alternative.getId(),
                alternative.getContent()
        );
    }
}
