package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.user.resource.UserResourceDTO;
import com.nexus.nexusrpg.controller.dto.user.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
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

    private final UserResourceRepository userResourceRepository;
    private final UserPlanetRepository userPlanetRepository;

    @Transactional(readOnly = true)
    public List<UserResourceReferenceDTO> getResources() {
        String email = authService.getAuthenticatedEmail();

        return userRepository.findByEmailWithResources(email)
                .map(user -> user.getResources().stream()
                        .map(userMapper::toUserResourceReferenceDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }

    public UserResourceDTO getResource(Long resourceId) {

        Long userId = authService.getAuthenticatedUser().getId();

        UserResource userResource = userResourceRepository.findByUserIdAndResourceIdOrThrow(userId, resourceId);

        return userMapper.toUserResourceDTO(userResource);
    }
}
