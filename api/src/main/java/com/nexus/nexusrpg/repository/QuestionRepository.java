package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    default Question findByIdOrThrow(Long questionId){
        return findById(questionId)
                .orElseThrow(() -> new BusinessException("Question", "Nenhum registro encontrado!", BAD_REQUEST));
    }
}
