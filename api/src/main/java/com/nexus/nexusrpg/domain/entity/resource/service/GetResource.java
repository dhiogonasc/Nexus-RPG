package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceRefDTO;
import com.nexus.nexusrpg.domain.mapper.ResourceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.ResourceRefMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UserResource;
import com.nexus.nexusrpg.domain.entity.resource.repository.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetResource extends GetEntity<
        Resource,
        UserResource,
        ResourceDTO,
        ResourceRefDTO
        > {

    public GetResource(
            Context context,
            UserResourceRepository repository,
            ResourceMapper mapper,
            ResourceRefMapper refMapper
    ) {

        super(
                context,
                "Resource",
                repository,
                mapper,
                refMapper
        );
    }

    @Override
    protected void validateAccess(UserResource userResource) {}
}
