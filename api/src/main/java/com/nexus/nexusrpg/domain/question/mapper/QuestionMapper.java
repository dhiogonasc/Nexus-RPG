package com.nexus.nexusrpg.domain.question.mapper;

import com.nexus.nexusrpg.domain.question.controller.dto.QuestionDTO;
import com.nexus.nexusrpg.domain.question.model.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDTO toDTO(Question question);
}
