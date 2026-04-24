package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.repository.relation.UserResourceRepository;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UResourceReferenceMapper extends ReferenceMapper<Resource, UResource> {

    private final ExecutionMapper<UResource> executionMapper;
    private final UserResourceRepository uResourceRepository;

    @Override
    public EntityReferenceDTO toReferenceDTO(UResource uResource){

        var resource = uResource.getResource();

        return new EntityReferenceDTO(
                resource.getId(),
                resource.getName(),
                resource.getDescription(),
                executionMapper.map(uResource)
        );
    }

    @Override
    protected UResource findRelation(User user, Resource resource) {
        return uResourceRepository.findByUserIdAndEntityId(user.getId(), resource.getId());
    }
}
