package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.request.UsuarioRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.UsuarioResponseDTO;
import com.nexus.nexusrpg.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequestDTO dto);

    @Mapping(target = "senha", ignore = true)
    UsuarioResponseDTO toResponse(Usuario entity);
}