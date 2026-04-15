package com.nexus.nexusrpg.domain.resource.service;

import com.nexus.nexusrpg.common.service.GetEntity;
import com.nexus.nexusrpg.common.service.UserContextService;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.relation.UserResourceMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.relation.UserResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetResource extends GetEntity<UserResource, UserResourceDTO, UserResourceReferenceDTO> {

    private final UserResourceRepository userResourceRepository;
    private final UserResourceMapper userResourceMapper;

    public GetResource(
            UserContextService userContextService,
            UserResourceRepository userResourceRepository,
            UserResourceMapper userResourceMapper
    ) {

        super(userContextService);
        this.userResourceRepository = userResourceRepository;
        this.userResourceMapper = userResourceMapper;
    }

    @Override
    protected List<UserResource> findAll(Long userId) {
        return userResourceRepository.findByUserId(userId);
    }

    @Override
    protected UserResource findById(Long userId, Long resourceId) {
        return userResourceRepository.findByUserIdAndResourceIdOrThrow(userId, resourceId);
    }

    @Override
    protected UserResourceDTO mapToDTO(UserResource userResource) {
        return userResourceMapper.toDTO(userResource);
    }

    @Override
    protected UserResourceReferenceDTO mapToReferenceDTO(UserResource userResource) {
        return userResourceMapper.toReferenceDTO(userResource);
    }

    @Override
    protected void validateAccess(UserResource userResource) {}
}
