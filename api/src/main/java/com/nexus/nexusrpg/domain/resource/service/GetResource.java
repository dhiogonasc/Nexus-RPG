package com.nexus.nexusrpg.domain.resource.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.UserContext;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.relation.UserResourceMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.relation.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetResource extends GetEntity<UserResource, UserResourceDTO, UserResourceReferenceDTO> {

    private final UserResourceMapper userResourceMapper;

    public GetResource(
            UserContext userContext,
            UserResourceRepository userResourceRepository,
            UserResourceMapper userResourceMapper
    ) {

        super(
                userContext,
                "Resource",
                userResourceRepository
        );

        this.userResourceMapper = userResourceMapper;
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
