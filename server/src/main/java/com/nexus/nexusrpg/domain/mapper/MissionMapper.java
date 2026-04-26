package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.MissionDetail;
import com.nexus.nexusrpg.domain.controller.dto.attempt.QuestionDTO;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.PlanetDynamicReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionMapper implements Mapper<UMission, MissionDetail>{

    private final ExecutionMapper<UMission> executionMapper;
    private final PlanetDynamicReferenceMapper referenceMapper;
    private final QuestionMapper questionMapper;

    public MissionDetail map(UMission uMission){
        var mission = uMission.getMission();

        return MissionDetail.builder()
                .id(mission.getId())
                .name(mission.getName())
                .description(mission.getDescription())
                .content(mission.getContent())
                .order(mission.getOrder())
                .questions(mapQuestions(uMission))
                .xpBonus(mission.getXpBonus())
                .bestResult(uMission.getBestResult())
                .execution(executionMapper.map(uMission))
                .planet(mapPlanet(uMission))
                .build();
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
