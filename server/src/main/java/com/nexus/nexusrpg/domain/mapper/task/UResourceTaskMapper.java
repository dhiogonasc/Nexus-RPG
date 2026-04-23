package com.nexus.nexusrpg.domain.mapper.task;

import com.nexus.nexusrpg.common.mapping.state.ProgressMapper;
import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import org.springframework.stereotype.Component;

@Component
public class UResourceTaskMapper extends TaskMapper<Resource, UResource> {

    public UResourceTaskMapper(
            ReferenceMapper<Resource, UResource> referenceMapper,
            ProgressMapper progressMapper) {
        super(referenceMapper, progressMapper);
    }
}
