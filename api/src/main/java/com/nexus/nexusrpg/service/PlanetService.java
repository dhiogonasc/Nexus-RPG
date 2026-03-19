package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.mapper.PlanetMapper;
import com.nexus.nexusrpg.repository.PlanetRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;

    public List<PlanetDTO> getAll() {

        return planetRepository.findAll()
                .stream()
                .map(planetMapper::toDTO)
                .toList();
    }

    public PlanetDTO getPlanet(Long id) {

        return planetMapper.toDTO(planetRepository.findByIdOrElseThrow(id));
    }
}
