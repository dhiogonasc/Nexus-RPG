package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.QuestionDTO;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.PlanetDynamicReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UMissionMapper implements Mapper<UMission, MissionDTO> {

    private final ExecutionMapper<UMission> executionMapper;
    private final PlanetDynamicReferenceMapper referenceMapper;
    private final QuestionMapper questionMapper;

    public MissionDTO map(UMission uMission){

        var mission = uMission.getMission();

        return new MissionDTO(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getContent(),
                mission.getXpBonus(),
                mapPlanet(uMission),
                mapQuestions(uMission),
                executionMapper.map(uMission),
                uMission.getBestResult(),
                mission.getOrder()
        );
    }

    private EntityDynamicReference mapPlanet(UMission uMission){
        var planet = uMission.getUPlanet();
        return referenceMapper.map(planet);
    }

    private List<QuestionDTO> mapQuestions(UMission uMission){
        var questions = uMission.getMission().getQuestions();
        return questions.stream()
                .map(questionMapper::map)
                .toList();
    }
}
