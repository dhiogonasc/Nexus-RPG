package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.AlternativeFeedbackDTO;
import com.nexus.nexusrpg.domain.model.Alternative;
import org.springframework.stereotype.Component;

@Component
public class AlternativeMapper implements Mapper<Alternative, AlternativeFeedbackDTO> {

    @Override
    public AlternativeFeedbackDTO toDTO(Alternative alternative) {
        return new AlternativeFeedbackDTO(
                alternative.getId(),
                alternative.getContent(),
                alternative.getIsCorrect()
        );
    }
}
