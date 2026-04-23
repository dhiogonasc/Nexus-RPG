package com.nexus.nexusrpg.domain.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptResponseDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptStartDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.ResponseDTO;
import com.nexus.nexusrpg.domain.mapper.ResponseMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.repository.AttemptRepository;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final Context context;
    private final UserMissionRepository userMissionRepository;
    private final AttemptRepository attemptRepository;
    private final UMissionReferenceMapper uMissionReferenceMapper;
    private final ResponseMapper responseMapper;

    @Transactional
    public AttemptResponseDTO start(AttemptStartDTO request) {

        var user = context.getAuthenticatedUser();

        var m = userMissionRepository
                .findByUserIdAndEntityId(
                        user.getId(),
                        request.missionId()
                );
        var mission = uMissionReferenceMapper.toReferenceDTO(m);

        var attempt = Attempt.builder()
                .mission(m)
                .build();
        attemptRepository.save(attempt);

        List<ResponseDTO> responses = attempt.getResponses().stream()
                .map(responseMapper::toDTO)
                .toList();

        return new AttemptResponseDTO(
                attempt.getId(),
                mission,
                attempt.getStartAt(),
                attempt.getEndAt(),
                attempt.getResult(),
                responses
        );
    }
}
