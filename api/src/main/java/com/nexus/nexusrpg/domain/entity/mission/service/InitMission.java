package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.entity.InitEntity;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.entity.mission.repository.MissionRepository;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.model.relation.UserMission;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
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
    protected UserMission initRelation(User user, Mission mission) {

        return UserMission.initialize(user, mission);
    }
}
