package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptResponseDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.ResponseDTO;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.MissionDynamicReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AttemptMapper implements Mapper<Attempt, AttemptResponseDTO> {

    private final MissionDynamicReferenceMapper referenceMapper;
    private final ResponseMapper responseMapper;

    @Override
    public AttemptResponseDTO map(Attempt attempt) {
        return new AttemptResponseDTO(
                attempt.getId(),
                attempt.getStartAt(),
                attempt.getEndAt(),
                attempt.getResult(),
                mapResponses(attempt),
                mapMission(attempt)
        );
    }

    private List<ResponseDTO> mapResponses(Attempt attempt) {
        return Optional.ofNullable(attempt.getResponses())
                .orElseGet(List::of)
                .stream()
                .map(responseMapper::map)
                .toList();
    }

    private EntityDynamicReference mapMission(Attempt attempt){
        var mission = attempt.getUMission();
        return referenceMapper.map(mission);
    }
}
