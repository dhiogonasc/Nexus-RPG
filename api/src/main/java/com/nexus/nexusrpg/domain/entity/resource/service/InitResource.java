package com.nexus.nexusrpg.domain.entity.resource.service;

import com.nexus.nexusrpg.common.entity.InitEntity;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.entity.resource.repository.ResourceRepository;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.entity.resource.repository.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class InitResource extends InitEntity<Resource, UResource> {


    public InitResource(
            ResourceRepository resourceRepository,
            UserResourceRepository userResourceRepository
    ) {

        super(resourceRepository, userResourceRepository);
    }

    @Override
    protected UResource initRelation(User user, Resource resource) {

        return UResource.initialize(user, resource);
    }
}
