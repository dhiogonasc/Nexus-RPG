package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTOR;
import com.nexus.nexusrpg.domain.mapper.UResourceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceRefMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.entity.resource.repository.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetResource extends GetEntity<
        Resource,
        UResource,
        UResourceDTO,
        UResourceDTOR
        > {

    public GetResource(
            Context context,
            UserResourceRepository repository,
            UResourceMapper mapper,
            UResourceRefMapper refMapper
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
    protected void validateAccess(UResource uResource) {}
}
