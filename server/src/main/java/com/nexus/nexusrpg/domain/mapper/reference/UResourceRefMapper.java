package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapper.RefMapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceRDTO;
import com.nexus.nexusrpg.domain.repository.relation.UResourceRepository;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UResourceRefMapper
        extends RefMapper<Resource, UResource, UResourceRDTO>
    implements ExecutionMapper<UResource>
{

    private final UResourceRepository uResourceRepository;

    @Override
    public UResourceRDTO toRefDTO(UResource uResource){

        var resource = uResource.getResource();

        return new UResourceRDTO(
                resource.getId(),
                resource.getName(),
                mapExecution(uResource)
        );
    }

    @Override
    protected UResource findRelation(User user, Resource resource) {
        return uResourceRepository.findByUserIdAndEntityId(user.getId(), resource.getId());
    }
}
