package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.interfaces.Initializable;
import com.nexus.nexusrpg.domain.mission.repository.MissionRepository;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitMissionService implements Initializable<UserMission> {

    private final MissionRepository missionRepository;

    @Override
    public List<UserMission> initialize(User user) {

        var allMission = missionRepository.findAll();

        return allMission.stream()
                .map(planet -> UserMission.initialize(user, planet))
                .toList();
    }
}
