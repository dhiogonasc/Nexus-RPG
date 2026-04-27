package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AnswerDTO;
import com.nexus.nexusrpg.domain.model.relation.Answer;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.repository.AlternativeRepository;
import com.nexus.nexusrpg.domain.repository.QuestionRepository;
import com.nexus.nexusrpg.domain.validator.AnswerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerMapper implements Mapper<Answer, AnswerDTO> {

    private final AnswerComponentMapper answerComponentMapper;
    private final AnswerValidator answerValidator;
    private final QuestionRepository questionRepository;
    private final AlternativeRepository alternativeRepository;

    @Override
    public AnswerDTO map(Answer answer) {
        boolean hit = answer.isHit();
        return new AnswerDTO(
                answer.getQuestion().getOrder(),
                answerComponentMapper.map(answer.getQuestion()),
                answerComponentMapper.map(answer.getAlternative()),
                hit ? null : answerComponentMapper.map(answer.getCorrect()),
                hit,
                answer.getExplanation()
        );
    }

    public Answer create(
            Attempt attempt,
            Long questionId,
            Long alternativeId) {

        var question = questionRepository.getReferenceById(questionId);
        var alternative = alternativeRepository.getReferenceById(alternativeId);

        answerValidator.validateResponseConsistency(attempt, question, alternative);

        return Answer.builder()
                .attempt(attempt)
                .question(question)
                .alternative(alternative)
                .build();
    }
}
