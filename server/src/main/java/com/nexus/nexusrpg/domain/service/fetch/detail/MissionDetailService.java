package com.nexus.nexusrpg.domain.service.fetch.detail;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.service.EntityDetailService;
import com.nexus.nexusrpg.domain.controller.dto.MissionDetail;
import com.nexus.nexusrpg.domain.mapper.MissionMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.validator.MissionValidator;
import org.springframework.stereotype.Service;

@Service
public class MissionDetailService extends EntityDetailService<UMission, MissionDetail> {

    private final MissionValidator validator;

    public MissionDetailService(
            Context context,
            UserMissionRepository repository,
            MissionMapper mapper,
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
