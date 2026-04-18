package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.entity.RefMapper;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.URExecutionDTO;
import com.nexus.nexusrpg.domain.entity.resource.repository.UserResourceRepository;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResourceRefMapper extends RefMapper<Resource, UResource, ResourceRefDTO> {

    private final UserResourceRepository repository;

    @Override
    public ResourceRefDTO toRefDTO(UResource ur){

        var resource = ur.getResource();
        var resourceExecution = new URExecutionDTO(ur.getStatus());

        return new ResourceRefDTO(
                resource.getId(),
                resource.getName(),
                resourceExecution
        );
    }

    @Override
    protected UResource findRelation(User user, Resource resource) {
        return repository.findByUserIdAndResourceIdOrThrow(user.getId(), resource.getId());
    }
}
