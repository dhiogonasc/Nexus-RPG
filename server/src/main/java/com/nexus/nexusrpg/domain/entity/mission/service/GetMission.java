package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.entity.service.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionRDTO;
import com.nexus.nexusrpg.domain.mapper.UMissionMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionReferenceMapper;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.relation.UMissionRepository;
import com.nexus.nexusrpg.domain.entity.mission.validator.MissionValidator;
import org.springframework.stereotype.Service;

@Service
public class GetMission extends GetEntity<
        Mission,
        UMission,
        UMissionDTO,
        UMissionRDTO
        > {

    private final MissionValidator validator;

    public GetMission(
            Context context,
            UMissionRepository repository,
            UMissionMapper mapper,
            UMissionReferenceMapper refMapper,
            MissionValidator validator
    ) {

        super(
                context,
                repository,
                mapper,
                refMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validate(UMission uMission) {
        validator.isAccessible(uMission);
    }
}
