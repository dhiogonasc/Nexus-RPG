package com.nexus.nexusrpg.domain.resource.service;

import com.nexus.nexusrpg.domain.auth.service.AuthService;
import com.nexus.nexusrpg.domain.resource.repository.ResourceRepository;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResourceService {

    private final AuthService authService;

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final ResourceRepository resourceRepository;
    private final UserResourceRepository userResourceRepository;

    @Transactional(readOnly = true)
    public List<UserResourceReferenceDTO> getResources() {

        User user = authService.getAuthenticatedUser();
        Long userId = user.getId();

        return userRepository
                .findByUserIdWithResources(userId)
                .map(u -> u.getResources().stream()
                        .map(userMapper::toUserResourceReferenceDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }

    public UserResourceDTO getResource(Long resourceId) {

        Long userId = authService.getAuthenticatedUser().getId();

        UserResource userResource = userResourceRepository.findByUserIdAndResourceIdOrThrow(userId, resourceId);

        return userMapper.toUserResourceDTO(userResource);
    }

    public List<UserResource> initialResources(User user){

         return resourceRepository.findAll().stream()
                .map(r -> UserResource.builder()
                        .user(user)
                        .resource(r)
                        .collected(false)
                        .build()
                )
                .toList();
    }
}
