package com.nexus.nexusrpg.domain.service.get;

import com.nexus.nexusrpg.common.mapping.state.ProgressMapper;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.UResourceDTO;
import com.nexus.nexusrpg.domain.mapper.UResourceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceReferenceMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.repository.relation.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceGetService extends GetService<
        Resource,
        UResource,
        UResourceDTO
        > {

    public ResourceGetService(
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

    @Override
    protected void validate(UResource uResource) {}
}
