package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.*;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetRDTO;
import com.nexus.nexusrpg.domain.entity.question.AlternativeDTO;
import com.nexus.nexusrpg.domain.entity.question.QuestionDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UMissionMapper implements
        Mapper<UMission, UMissionDTO>,
        ExecutionMapper<UMission>
{

    private final UPlanetReferenceMapper uPlanetRefMapper;

    public UMissionDTO toDTO(UMission uMission){

        var mission = uMission.getMission();

        return new UMissionDTO(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getXpBonus(),
                mapQuestions(uMission),
                mapPlanet(uMission),
                mapExecution(uMission)
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

    public UPlanetRDTO mapPlanet(UMission uMission){

        var user = uMission.getUser();
        var planet = uMission.getPlanet();

        return uPlanetRefMapper.mapReference(user, planet);
    }
}
