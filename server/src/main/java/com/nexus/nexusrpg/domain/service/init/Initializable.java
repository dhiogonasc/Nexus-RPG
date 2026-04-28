package com.nexus.nexusrpg.domain.service.init;

import com.nexus.nexusrpg.user.model.User;

public interface Initializable {
    void initialize(User user);
}
