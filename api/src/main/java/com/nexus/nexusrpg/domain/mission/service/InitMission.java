package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.init.InitEntity;
import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.mission.repository.MissionRepository;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import org.springframework.stereotype.Service;

@Service
public class InitMission extends InitEntity<Mission, UserMission> {

    public InitMission(
            MissionRepository missionRepository,
            UserMissionRepository userMissionRepository
    ) {

        super(missionRepository, userMissionRepository);
    }

    @Override
    protected UserMission mapToRelation(User user, Mission mission) {

        return UserMission.initialize(user, mission);
    }
}
