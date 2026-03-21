package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.global.question.QuestionDTO;
import com.nexus.nexusrpg.model.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDTO toDTO(Question question);
}
