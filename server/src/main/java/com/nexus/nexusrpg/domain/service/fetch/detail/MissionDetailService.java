package com.nexus.nexusrpg.domain.service.fetch.detail;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.mapper.UMissionMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.validator.MissionValidator;
import org.springframework.stereotype.Service;

@Service
public class MissionDetailService extends DetailService<UMission, MissionDTO> {

    private final MissionValidator validator;

    public MissionDetailService(
            Context context,
            UserMissionRepository repository,
            UMissionMapper mapper,
            MissionValidator validator
    ) {
        super(context, repository, mapper);
        this.validator = validator;
    }

    @Override
    protected void validate(UMission uMission) {
        this.validator.isAccessible(uMission);
    }
}
