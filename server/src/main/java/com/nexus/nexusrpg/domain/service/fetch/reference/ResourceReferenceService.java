package com.nexus.nexusrpg.domain.service.fetch.reference;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.ResourceDTO;
import com.nexus.nexusrpg.domain.mapper.UResourceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceReferenceMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.repository.relation.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceReferenceService extends ReferenceService<
        Resource,
        UResource,
        ResourceDTO
        > {

    public ResourceReferenceService(
            Context context,
            UserResourceRepository repository,
            UResourceMapper mapper,
            UResourceReferenceMapper refMapper,
            ProgressMapper progressMapper
    ) {
        super(
                context,
                repository,
                mapper,
                refMapper,
                progressMapper
        );
    }
}
