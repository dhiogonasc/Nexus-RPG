package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.RegisterResponseDTO;
import com.nexus.nexusrpg.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    User toEntity(RegisterRequestDTO dto);

    RegisterResponseDTO toResponse(User entity);
}