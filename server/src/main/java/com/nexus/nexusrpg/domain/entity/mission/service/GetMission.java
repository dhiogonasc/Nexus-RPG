package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.mapping.mapper.TaskMapper;
import com.nexus.nexusrpg.common.service.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.UMissionDTO;
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
        UMissionDTO
        > {

    private final MissionValidator validator;

    public GetMission(
            Context context,
            UMissionRepository repository,
            UMissionMapper mapper,
            UMissionReferenceMapper refMapper,
            MissionValidator validator,
            TaskMapper taskMapper
    ) {

        super(
                context,
                repository,
                mapper,
                refMapper,
                taskMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validate(UMission uMission) {
        validator.isAccessible(uMission);
    }
}
