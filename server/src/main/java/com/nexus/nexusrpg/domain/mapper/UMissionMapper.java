package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.entity.question.AlternativeDTO;
import com.nexus.nexusrpg.domain.entity.question.QuestionDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UMissionMapper implements Mapper<UMission, MissionDTO> {

    private final ExecutionMapper<UMission> executionMapper;
    private final UPlanetReferenceMapper uPlanetReferenceMapper;

    public MissionDTO toDTO(UMission uMission){

        var mission = uMission.getMission();

        return new MissionDTO(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getXpBonus(),
                mapQuestions(uMission),
                mapPlanet(uMission),
                executionMapper.map(uMission)
        );
    }

    private List<QuestionDTO> mapQuestions(UMission uMission) {

        return uMission.getQuestions().stream()
                .map(question -> new QuestionDTO(
                        question.getId(),
                        question.getContent(),
                        question.getCodeSnippet(),
                        question.getAlternatives().stream()
                                .map(alternative -> new AlternativeDTO(
                                        alternative.getId(),
                                        alternative.getContent()
                                ))
                                .toList()
                ))
                .toList();
    }

    public EntityReferenceDTO mapPlanet(UMission uMission){

        var user = uMission.getUser();
        var planet = uMission.getPlanet();

        return uPlanetReferenceMapper.map(user, planet);
    }
}
