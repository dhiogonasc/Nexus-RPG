package com.nexus.nexusrpg.domain.service.get;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.mapper.UMissionMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionReferenceMapper;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.validator.MissionValidator;
import org.springframework.stereotype.Service;

@Service
public class MissionGetService extends GetService<
        Mission,
        UMission,
        MissionDTO
        > {

    private final MissionValidator validator;

    public MissionGetService(
            Context context,
            UserMissionRepository repository,
            UMissionMapper mapper,
            UMissionReferenceMapper refMapper,
            MissionValidator validator,
            ProgressMapper progressMapper
    ) {

        super(
                context,
                repository,
                mapper,
                refMapper,
                progressMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validate(UMission uMission) {
        validator.isAccessible(uMission);
    }
}
