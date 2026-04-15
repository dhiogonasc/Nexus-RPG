package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.entity.resource.mapper.UserResourceMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.entity.resource.repository.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetResource extends GetEntity<UserResource, UserResourceDTO, UserResourceReferenceDTO> {

    private final UserResourceMapper userResourceMapper;

    public GetResource(
            Context context,
            UserResourceRepository userResourceRepository,
            UserResourceMapper userResourceMapper
    ) {

        super(
                context,
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
