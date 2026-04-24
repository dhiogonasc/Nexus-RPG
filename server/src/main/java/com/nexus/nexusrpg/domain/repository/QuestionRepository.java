package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    default Question findByIdOrThrow(long id) {
        return findById(id)
                .orElseThrow(() -> new BusinessException("Question", "Nenhum registro encontrado", NOT_FOUND));
    }
}
