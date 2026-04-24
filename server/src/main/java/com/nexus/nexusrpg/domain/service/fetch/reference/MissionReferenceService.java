package com.nexus.nexusrpg.domain.service.fetch.reference;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.mapper.UMissionMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionReferenceMapper;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import org.springframework.stereotype.Service;

@Service
public class MissionReferenceService extends ReferenceService<
        Mission,
        UMission,
        MissionDTO
        > {

    public MissionReferenceService(
            Context context,
            UserMissionRepository repository,
            UMissionMapper mapper,
            UMissionReferenceMapper referenceMapper,
            ProgressMapper progressMapper
    ) {

        super(
                context,
                repository,
                mapper,
                referenceMapper,
                progressMapper
        );
    }
}
