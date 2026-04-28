package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import org.springframework.stereotype.Component;

@Component
public class CurrentResourceMapper extends CurrentMapper<Resource, UResource>{
    public CurrentResourceMapper(ReferenceMapper<Resource, UResource> referenceMapper) {
        super(referenceMapper);
    }
}
