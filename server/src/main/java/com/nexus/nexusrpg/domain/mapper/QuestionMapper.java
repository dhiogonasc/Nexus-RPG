package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.QuestionDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AnswerComponentDTO;
import com.nexus.nexusrpg.domain.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionMapper implements Mapper<Question, QuestionDTO> {

    private final AnswerComponentMapper answerComponentMapper;

    @Override
    public QuestionDTO map(Question question) {
        return new QuestionDTO(
                question.getId(),
                question.getContent(),
                question.getOrder(),
                mapAlternative(question)
        );
    }

    private List<AnswerComponentDTO> mapAlternative(Question question){
        var alternatives = question.getAlternatives();
        return alternatives.stream()
                .map(answerComponentMapper::map)
                .toList();
    }
}
