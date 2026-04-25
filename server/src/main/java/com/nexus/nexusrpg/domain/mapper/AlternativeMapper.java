package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.response.AlternativeDTO;
import com.nexus.nexusrpg.domain.model.Alternative;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlternativeMapper implements Mapper<Alternative, AlternativeDTO> {

    @Override
    public AlternativeDTO map(Alternative alternative) {
        return new AlternativeDTO(
                alternative.getId(),
                alternative.getContent()
        );
    }
}
