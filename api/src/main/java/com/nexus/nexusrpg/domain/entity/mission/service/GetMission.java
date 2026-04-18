package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.mapper.UMissionMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionRefMapper;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.entity.mission.validator.MissionValidator;
import org.springframework.stereotype.Service;

@Service
public class GetMission extends GetEntity<
        Mission,
        UMission,
        UMissionDTO,
        UMissionDTOR
        > {

    private final MissionValidator validator;

    public GetMission(
            Context context,
            UserMissionRepository repository,
            UMissionMapper mapper,
            UMissionRefMapper refMapper,
            MissionValidator validator
    ) {

        super(
                context,
                "Mission",
                repository,
                mapper,
                refMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validateAccess(UMission uMission) {
        validator.isAccessible(uMission);
    }
}
