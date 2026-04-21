package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.entity.service.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTOR;
import com.nexus.nexusrpg.domain.entity.resource.validator.ResourceValidator;
import com.nexus.nexusrpg.domain.mapper.UResourceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceRefMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.repository.relation.UResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetResource extends GetEntity<
        Resource,
        UResource,
        UResourceDTO,
        UResourceDTOR
        > {

    private final ResourceValidator validator;

    public GetResource(
            Context context,
            UResourceRepository repository,
            UResourceMapper mapper,
            UResourceRefMapper refMapper,
            ResourceValidator validator
    ) {
        super(
                context,
                repository,
                mapper,
                refMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validate(UResource uResource) {
        validator.isCollectable(uResource);
    }
}
