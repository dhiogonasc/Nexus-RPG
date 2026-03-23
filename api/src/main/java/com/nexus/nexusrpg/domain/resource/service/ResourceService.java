package com.nexus.nexusrpg.domain.resource.service;

import com.nexus.nexusrpg.domain.auth.service.AuthService;
import com.nexus.nexusrpg.domain.resource.controller.dto.CollectedResourcesDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ResourceService {

    private final AuthService authService;

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final UserResourceRepository userResourceRepository;
    private final UserPlanetRepository userPlanetRepository;

    @Transactional(readOnly = true)
    public CollectedResourcesDTO getResources() {

        User user = authService.getAuthenticatedUser();

        return userMapper.mapCollectedResources(user);
    }

    public UserResourceDTO getResource(Long resourceId) {

        Long userId = authService.getAuthenticatedUser().getId();

        UserResource userResource = userResourceRepository.findByUserIdAndResourceIdOrThrow(userId, resourceId);

        return userMapper.toUserResourceDTO(userResource);
    }
}
