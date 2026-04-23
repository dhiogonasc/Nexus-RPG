package com.nexus.nexusrpg.domain.service.init;

import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.repository.ResourceRepository;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.domain.repository.relation.UserResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceInitService extends InitService<Resource, UResource> {


    public ResourceInitService(
            ResourceRepository resourceRepository,
            UserResourceRepository uResourceRepository
    ) {
        super(resourceRepository, uResourceRepository);
    }

    @Override
    protected UResource initRelation(User user, Resource resource) {
        return UResource.initialize(user, resource);
    }
}
