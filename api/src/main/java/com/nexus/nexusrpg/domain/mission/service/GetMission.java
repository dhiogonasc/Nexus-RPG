package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.UserContext;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.relation.UserMissionMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
import org.springframework.stereotype.Service;

@Service
public class GetMission extends GetEntity<UserMission, UserMissionDTO, UserMissionReferenceDTO> {

    private final UserPlanetRepository userPlanetRepository;
    private final UserMissionMapper userMissionMapper;
    private final MissionValidator missionValidator;
    private final PlanetValidator planetValidator;

    public GetMission(
            UserContext userContext,
            UserMissionRepository userMissionRepository,
            UserPlanetRepository userPlanetRepository,
            UserMissionMapper userMissionMapper,
            MissionValidator missionValidator,
            PlanetValidator planetValidator
    ) {

        super(
                userContext,
                "Mission",
                userMissionRepository
        );

        this.userPlanetRepository = userPlanetRepository;
        this.userMissionMapper = userMissionMapper;
        this.missionValidator = missionValidator;
        this.planetValidator = planetValidator;
    }

    @Override
    protected UserMissionDTO mapToDTO(UserMission userMission) {
        return userMissionMapper.toDTO(userMission);
    }

    @Override
    protected UserMissionReferenceDTO mapToReferenceDTO(UserMission userMission) {
        return userMissionMapper.toReferenceDTO(userMission);
    }

    @Override
    protected void validateAccess(UserMission userMission) {

        var userId = userMission.getUser().getId();
        var planetId = userMission.getMission().getPlanet().getId();

        var userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(userId, planetId);

        planetValidator.isAccessible(userPlanet);
        missionValidator.isAccessible(userMission);
    }
}
