package com.nexus.nexusrpg.domain.mapper.feedback;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class FeedbackMapper<Entity, EntityFeedbackDTO> {
    public abstract EntityFeedbackDTO map(Entity entity);
}