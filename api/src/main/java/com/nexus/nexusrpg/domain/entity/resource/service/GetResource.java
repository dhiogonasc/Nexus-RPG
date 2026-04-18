package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceRefDTO;
import com.nexus.nexusrpg.domain.model.relation.UserResource;
import com.nexus.nexusrpg.domain.entity.resource.repository.UserResourceRepository;
import org.springframework.stereotype.Service;

import static com.nexus.nexusrpg.domain.mapper.ResourceMapper.toDTO;
import static com.nexus.nexusrpg.domain.mapper.ResourceMapper.toRefDTO;

@Service
public class GetResource extends GetEntity<UserResource, ResourceDTO, ResourceRefDTO> {

    public GetResource(
            Context context,
            UserResourceRepository userResourceRepository
    ) {

        super(
                context,
                "Resource",
                userResourceRepository
        );
    }

    @Override
    protected ResourceDTO mapToDTO(UserResource userResource) {
        return toDTO(userResource);
    }

    @Override
    protected ResourceRefDTO mapToReferenceDTO(UserResource userResource) {
        return toRefDTO(userResource);
    }

    @Override
    protected void validateAccess(UserResource userResource) {}
}
