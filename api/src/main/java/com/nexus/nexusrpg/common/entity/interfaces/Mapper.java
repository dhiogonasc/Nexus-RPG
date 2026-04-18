package com.nexus.nexusrpg.common.entity.interfaces;

public interface Mapper<UserEntity, UserEntityDTO> {

    UserEntityDTO toDTO(UserEntity userEntity);
}
