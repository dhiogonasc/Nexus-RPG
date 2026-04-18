package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.entity.RefMapper;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTOR;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceExecDTO;
import com.nexus.nexusrpg.domain.repository.UResourceRepository;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UResourceRefMapper extends RefMapper<Resource, UResource, UResourceDTOR> {

    private final UResourceRepository uResourceRepository;

    @Override
    public UResourceDTOR toRefDTO(UResource ur){

        var resource = ur.getResource();
        var execution = new UResourceExecDTO(ur.getStatus());

        return new UResourceDTOR(
                resource.getId(),
                resource.getName(),
                execution
        );
    }

    @Override
    protected UResource findRelation(User user, Resource resource) {
        return uResourceRepository.findByUserIdAndEntityId(user.getId(), resource.getId());
    }
}
