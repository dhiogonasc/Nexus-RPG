package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.entity.InitEntity;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.repository.MissionRepository;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.repository.relation.UMissionRepository;
import org.springframework.stereotype.Service;

@Service
public class InitMission extends InitEntity<Mission, UMission> {

    public InitMission(
            MissionRepository missionRepository,
            UMissionRepository uMissionRepository
    ) {

        super(missionRepository, uMissionRepository);
    }

    @Override
    protected UMission initRelation(User user, Mission mission) {

        return UMission.initialize(user, mission);
    }
}
