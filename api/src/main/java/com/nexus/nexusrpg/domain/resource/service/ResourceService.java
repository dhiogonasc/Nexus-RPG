package com.nexus.nexusrpg.domain.resource.service;

import com.nexus.nexusrpg.common.service.UserContextService;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.relation.UserResourceMapper;
import com.nexus.nexusrpg.domain.user.repository.relation.UserResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResourceService {

    private final UserContextService userContextService;
    private final UserResourceRepository userResourceRepository;
    private final UserResourceMapper userResourceMapper;

    @Transactional(readOnly = true)
    public List<UserResourceReferenceDTO> getAll() {

        var user = userContextService.getAuthenticatedUser();

        return userResourceRepository
                .findByUserId(user.getId()).stream()
                .map(userResourceMapper::toReferenceDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResourceDTO getById(Long resourceId) {

        var userId = userContextService.getAuthenticatedUser().getId();

        var userResource = userResourceRepository
                .findByUserIdAndResourceIdOrThrow(userId, resourceId);

        return userResourceMapper.toDTO(userResource);
    }
}
