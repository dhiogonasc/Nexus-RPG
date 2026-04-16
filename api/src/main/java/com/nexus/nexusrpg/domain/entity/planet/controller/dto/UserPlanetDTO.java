package com.nexus.nexusrpg.domain.entity.planet.controller.dto;

public record UserPlanetDTO(

        PlanetDTO planet,
        UserPlanetStatsDTO stats
) {}