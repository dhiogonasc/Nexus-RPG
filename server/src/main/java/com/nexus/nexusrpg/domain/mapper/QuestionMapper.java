package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.AlternativeDTO;
import com.nexus.nexusrpg.domain.controller.dto.QuestionDTO;
import com.nexus.nexusrpg.domain.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionMapper implements Mapper<Question, QuestionDTO> {

    private final AlternativeMapper alternativeMapper;

    @Override
    public QuestionDTO toDTO(Question question) {
        return new QuestionDTO(
                question.getId(),
                question.getContent(),
                question.getOrder(),
                mapAlternative(question)
        );
    }

    private List<AlternativeDTO> mapAlternative(Question question){
        var alternatives = question.getAlternatives();
        return alternatives.stream()
                .map(alternativeMapper::toDTO)
                .toList();
    }
}
