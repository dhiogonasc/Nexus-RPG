package com.nexus.nexusrpg.domain.resource.service;

import com.nexus.nexusrpg.common.interfaces.Initializable;
import com.nexus.nexusrpg.domain.resource.repository.ResourceRepository;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitResourceService implements Initializable<UserResource> {

    private final ResourceRepository resourceRepository;

    @Override
    public List<UserResource> initialize(User user) {

        var allResources = resourceRepository.findAll();

        return allResources.stream()
                .map(resource -> UserResource.initialize(user, resource))
                .toList();
    }
}
