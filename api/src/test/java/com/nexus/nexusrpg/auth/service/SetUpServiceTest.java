package com.nexus.nexusrpg.auth.service;

import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.core.exception.BusinessException;

import com.nexus.nexusrpg.domain.auth.service.SetUpService;
import com.nexus.nexusrpg.domain.level.model.Level;
import com.nexus.nexusrpg.domain.level.repository.LevelRepository;

import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.planet.repository.PlanetRepository;

import com.nexus.nexusrpg.domain.resource.model.Resource;
import com.nexus.nexusrpg.domain.resource.repository.ResourceRepository;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SetUpServiceTest {

    @Mock private LevelRepository levelRepository;
    @Mock private PlanetRepository planetRepository;
    @Mock private ResourceRepository resourceRepository;

    @InjectMocks
    private SetUpService setUpService;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .planets(new ArrayList<>())
                .missions(new ArrayList<>())
                .resources(new ArrayList<>())
                .build();
    }

    @Nested
    @DisplayName("Testes de Inicialização de Nível")
    class LevelSetupTests {

        @Test
        @DisplayName("Deve configurar o nível 1 com sucesso")
        void shouldSetUpInitialLevelSuccessfully() {
            var level1 = new Level();
            level1.setId(1L);
            when(levelRepository.findById(1L)).thenReturn(Optional.of(level1));

            setUpService.setUpInitialLevel(user);

            assertThat(user.getLevel()).isEqualTo(level1);
        }

        @Test
        @DisplayName("Deve lançar BusinessException quando o nível 1 não existir no banco")
        void shouldThrowExceptionWhenLevel1NotFound() {
            when(levelRepository.findById(1L)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> setUpService.setUpInitialLevel(user))
                    .isInstanceOf(BusinessException.class)
                    .hasMessageContaining("Level 1 não encontrado");
        }
    }

    @Nested
    @DisplayName("Testes de Inicialização de Planetas e Missões")
    class RelationSetupTests {

        @Test
        @DisplayName("Deve desbloquear apenas o primeiro planeta e bloquear os demais")
        void shouldSetUpInitialPlanetsCorrectly() {

            var p1 = Planet.builder().id(1L).build();
            var p2 = Planet.builder().id(2L).build();
            when(planetRepository.findAll()).thenReturn(List.of(p1, p2));

            setUpService.setUpInitialUserPlanets(user);

            assertThat(user.getPlanets()).hasSize(2);

            var userP1 = user.getPlanets().stream().filter(p -> p.getPlanet().getId().equals(1L)).findFirst().get();
            var userP2 = user.getPlanets().stream().filter(p -> p.getPlanet().getId().equals(2L)).findFirst().get();

            assertThat(userP1.getStatus()).isEqualTo(EntityStatus.UNLOCKED);
            assertThat(userP1.getIsAccessible()).isTrue();
            assertThat(userP1.getIsCurrent()).isTrue();

            assertThat(userP2.getStatus()).isEqualTo(EntityStatus.LOCKED);
            assertThat(userP2.getIsAccessible()).isFalse();
        }

        @Test
        @DisplayName("Deve vincular todos os recursos como não coletados")
        void shouldSetUpInitialResources() {
            var r1 = Resource.builder().id(10L).build();
            when(resourceRepository.findAll()).thenReturn(List.of(r1));

            setUpService.setUpInitialUserResources(user);

            assertThat(user.getResources()).hasSize(1);
            assertThat(user.getResources().get(0).getCollectedAt()).isNull();
        }
    }

    @Nested
    @DisplayName("Testes de Stats Iniciais")
    class StatsTests {

        @Test
        @DisplayName("Deve zerar XP e encher oxigênio")
        void shouldInitializeStats() {
            user.setXp(500);

            setUpService.initialStats(user);

            assertThat(user.getXp()).isZero();
        }
    }
}