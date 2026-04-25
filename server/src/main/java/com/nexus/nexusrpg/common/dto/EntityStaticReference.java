package com.nexus.nexusrpg.common.dto;

public record EntityStaticReference(
        Long id,
        String name,
        String description
) implements StaticReference{

    @Override
    public Long id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String description() {
        return this.description;
    }
}
