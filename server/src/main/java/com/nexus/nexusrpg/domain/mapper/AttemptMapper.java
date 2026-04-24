package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptResponseDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.ResponseDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AttemptMapper implements Mapper<Attempt, AttemptResponseDTO> {

    private final UMissionReferenceMapper uMissionReferenceMapper;
    private final ResponseMapper responseMapper;

    @Override
    public AttemptResponseDTO toDTO(Attempt attempt) {
        return new AttemptResponseDTO(
                attempt.getId(),
                mapMission(attempt),
                attempt.getStartAt(),
                attempt.getEndAt(),
                attempt.getResult(),
                mapResponses(attempt)
        );
    }

    private List<ResponseDTO> mapResponses(Attempt attempt) {
        return Optional.ofNullable(attempt.getResponses())
                .orElseGet(List::of)
                .stream()
                .map(responseMapper::toDTO)
                .toList();
    }

    private EntityReferenceDTO mapMission(Attempt attempt){
        var mission = attempt.getMission();
        return uMissionReferenceMapper.toReferenceDTO(mission);
    }
}
