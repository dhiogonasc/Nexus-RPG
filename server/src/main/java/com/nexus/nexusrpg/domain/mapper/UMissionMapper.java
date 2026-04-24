package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionDTO;
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
    private final QuestionMapper questionMapper;

    public MissionDTO toDTO(UMission uMission){

        var mission = uMission.getMission();

        return new MissionDTO(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getXpBonus(),
                mapPlanet(uMission),
                mapQuestions(uMission),
                executionMapper.map(uMission),
                uMission.getBestResult(),
                mission.getOrder()
        );
    }

    private EntityReferenceDTO mapPlanet(UMission uMission){
        var user = uMission.getUser();
        var planet = uMission.getPlanet();

        return uPlanetReferenceMapper.map(user, planet);
    }

    private List<QuestionDTO> mapQuestions(UMission uMission){
        var questions = uMission.getMission().getQuestions();
        return questions.stream()
                .map(questionMapper::toDTO)
                .toList();
    }
}
