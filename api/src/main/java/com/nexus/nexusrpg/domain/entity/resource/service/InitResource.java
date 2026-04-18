package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.entity.InitEntity;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.repository.ResourceRepository;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.repository.relation.UResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class InitResource extends InitEntity<Resource, UResource> {


    public InitResource(
            ResourceRepository resourceRepository,
            UResourceRepository uResourceRepository
    ) {

        super(resourceRepository, uResourceRepository);
    }

    @Override
    protected UResource initRelation(User user, Resource resource) {

        return UResource.initialize(user, resource);
    }
}
