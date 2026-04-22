package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.mapping.mapper.TaskMapper;
import com.nexus.nexusrpg.common.service.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceRDTO;
import com.nexus.nexusrpg.domain.mapper.UResourceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceReferenceMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.repository.relation.UResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetResource extends GetEntity<
        Resource,
        UResource,
        UResourceDTO,
        UResourceRDTO
        > {

    public GetResource(
            Context context,
            UResourceRepository repository,
            UResourceMapper mapper,
            UResourceReferenceMapper refMapper,
            TaskMapper<UResourceRDTO> taskMapper
    ) {
        super(
                context,
                repository,
                mapper,
                refMapper,
                taskMapper
        );
    }

    @Override
    protected void validate(UResource uResource) {}
}
