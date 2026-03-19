package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.mission.MissionDTO;
import com.nexus.nexusrpg.mapper.MissionMapper;
import com.nexus.nexusrpg.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public List<MissionDTO> getAll() {

        return missionRepository.findAll()
                .stream()
                .map(missionMapper::toDTO)
                .toList();
    }

    public MissionDTO getPlanet(Long id) {

        return missionMapper.toDTO(missionRepository.findByIdOrElseThrow(id));
    }
}
