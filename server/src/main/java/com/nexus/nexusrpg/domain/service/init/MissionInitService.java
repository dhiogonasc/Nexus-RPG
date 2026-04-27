package com.nexus.nexusrpg.domain.service.init;

import com.nexus.nexusrpg.common.service.EntityInitService;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.MissionRepository;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class MissionInitService extends EntityInitService<Mission, UMission> {

    public MissionInitService(
            MissionRepository missionRepository,
            UserMissionRepository uMissionRepository
    ) {
        super(missionRepository, uMissionRepository);
    }

    @Override
    protected UMission initRelation(User user, Mission mission) {
        return UMission.initialize(user, mission);
    }
}
