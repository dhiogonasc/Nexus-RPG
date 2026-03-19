package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.mission.MissionDTO;
import com.nexus.nexusrpg.mapper.MissionMapper;
import com.nexus.nexusrpg.repository.MissionRepository;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    @GetMapping
    public ResponseEntity<List<MissionDTO>> listarTodos() {
        List<MissionDTO> missions = missionRepository.findAll()
                .stream()
                .map(missionMapper::toDTO)
                .toList();

        return ResponseEntity.ok(missions);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(
                missionMapper.toDTO(missionRepository.findById(id))
        );
    }
}