package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.mapper.PlanetMapper;
import com.nexus.nexusrpg.repository.PlanetRepository;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;


    @GetMapping
    public ResponseEntity<List<PlanetDTO>> listarTodos() {

        List<PlanetDTO> planets = planetRepository.findAll()
                .stream()
                .map(planetMapper::toDTO)
                .toList();

        return ResponseEntity.ok(planets);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(planetMapper.toDTO(planetRepository.findById(id).orElseThrow()));
    }
}
