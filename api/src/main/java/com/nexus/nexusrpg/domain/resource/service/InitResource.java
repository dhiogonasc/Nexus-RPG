package com.nexus.nexusrpg.domain.resource.service;

import com.nexus.nexusrpg.common.entity.InitEntity;
import com.nexus.nexusrpg.domain.resource.model.Resource;
import com.nexus.nexusrpg.domain.resource.repository.ResourceRepository;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.relation.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class InitResource extends InitEntity<Resource, UserResource> {


    public InitResource(
            ResourceRepository resourceRepository,
            UserResourceRepository userResourceRepository
    ) {

        super(resourceRepository, userResourceRepository);
    }

    @Override
    protected UserResource mapToRelation(User user, Resource resource) {

        return UserResource.initialize(user, resource);
    }
}
