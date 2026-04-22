package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapping.mapper.TaskMapper;
import com.nexus.nexusrpg.common.mapping.mapper.ReferenceMapper;
import com.nexus.nexusrpg.common.mapping.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.repository.relation.UResourceRepository;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import com.nexus.nexusrpg.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UResourceReferenceMapper extends ReferenceMapper<Resource, UResource> {

    private final ExecutionMapper<UResource> executionMapper;
    private final UResourceRepository uResourceRepository;

    public UResourceReferenceMapper(
            TaskMapper taskMapper,
            ExecutionMapper<UResource> executionMapper,
            UResourceRepository uResourceRepository
    ) {
        super(taskMapper);
        this.executionMapper = executionMapper;
        this.uResourceRepository = uResourceRepository;
    }

    @Override
    public EntityReferenceDTO toReferenceDTO(UResource uResource){

        var resource = uResource.getResource();

        return new EntityReferenceDTO(
                resource.getId(),
                resource.getName(),
                executionMapper.map(uResource)
        );
    }

    @Override
    protected UResource findRelation(User user, Resource resource) {
        return uResourceRepository.findByUserIdAndEntityId(user.getId(), resource.getId());
    }
}
