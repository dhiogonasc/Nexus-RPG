package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapping.mapper.ReferenceMapper;
import com.nexus.nexusrpg.common.mapping.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.mapping.mapper.TaskMapper;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.repository.relation.UMissionRepository;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UMissionReferenceMapper extends ReferenceMapper<Mission, UMission> {

    private final ExecutionMapper<UMission> executionMapper;
    private final UMissionRepository uMissionRepository;

    public UMissionReferenceMapper(
            TaskMapper taskMapper,
            ExecutionMapper<UMission> executionMapper,
            UMissionRepository uMissionRepository) {

        super(taskMapper);
        this.executionMapper = executionMapper;
        this.uMissionRepository = uMissionRepository;
    }

    @Override
    public EntityReferenceDTO toReferenceDTO(UMission uMission) {

        var mission =  uMission.getMission();

        return new EntityReferenceDTO(
                mission.getId(),
                mission.getName(),
                executionMapper.map(uMission)
        );
    }

    @Override
    protected UMission findRelation(User user, Mission mission) {
        return uMissionRepository.findByUserIdAndEntityId(user.getId(), mission.getId());
    }
}
