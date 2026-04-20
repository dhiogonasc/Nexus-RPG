package com.nexus.nexusrpg.domain.entity.mission.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UAttemptDTO;
import com.nexus.nexusrpg.domain.entity.mission.model.UAttempt;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionRefMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UAttemptMapper {

    private final UMissionRefMapper uMissionRefMapper;

    public UAttemptDTO toDTO(UAttempt uAttempt){

        var uMission = uMissionRefMapper.toRefDTO(uAttempt.getUMission());

        return new UAttemptDTO(
                uAttempt.getId(),
                uMission,
                uAttempt.getStartAt(),
                uAttempt.getEndAt(),
                uAttempt.getResult()
        );
    }
}
