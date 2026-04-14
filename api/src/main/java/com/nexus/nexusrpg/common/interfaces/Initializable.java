package com.nexus.nexusrpg.common.interfaces;

import com.nexus.nexusrpg.domain.user.model.User;

import java.util.List;

public interface Initializable<T> {

    List<T> initialize(User user);
}
