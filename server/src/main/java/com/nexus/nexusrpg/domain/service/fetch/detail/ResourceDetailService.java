package com.nexus.nexusrpg.domain.service.fetch.detail;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.ResourceDTO;
import com.nexus.nexusrpg.domain.mapper.UResourceMapper;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.repository.relation.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceDetailService extends DetailService<UResource, ResourceDTO> {

    public ResourceDetailService(
            Context context,
            UserResourceRepository repository,
            UResourceMapper mapper
    ) {
        super(context, repository, mapper);
    }

    @Override
    protected void validate(UResource uResource) {}
}
