package com.nexus.nexusrpg.auth.service;

import com.nexus.nexusrpg.domain.auth.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.domain.auth.service.AuthService;
import com.nexus.nexusrpg.domain.auth.service.SetUpService;
import com.nexus.nexusrpg.domain.auth.validator.AuthValidator;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock private SetUpService setUpService;
    @Mock private AuthValidator authValidator;
    @Mock private UserRepository userRepository;
    @Mock private BCryptPasswordEncoder encoder;
    @Mock private JwtEncoder jwtEncoder;

    @InjectMocks
    private AuthService authService;

    @Nested
    @DisplayName("Testes do método register")
    class RegisterTests {

        @Test
        @DisplayName("Deve registrar um usuário com sucesso e configurar dados iniciais")
        void shouldRegisterUserSuccessfully() {

            var request = new RegisterRequestDTO("nexus_user", "test@nexus.com", "password123");
            when(encoder.encode(any())).thenReturn("encoded_password");

            authService.register(request);

            ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
            verify(userRepository).save(userCaptor.capture());

            User savedUser = userCaptor.getValue();
            assertThat(savedUser.getUsername()).isEqualTo("nexus_user");
            assertThat(savedUser.getPassword()).isEqualTo("encoded_password");

            verify(setUpService).initialStats(savedUser);
            verify(setUpService).setUpInitialLevel(savedUser);
            verify(setUpService).setUpInitialUserPlanets(savedUser);
        }
    }

    @Nested
    @DisplayName("Testes do método login")
    class LoginTests {

        @Test
        @DisplayName("Deve realizar login e retornar DTO com token JWT")
        void shouldLoginSuccessfully() {

            var request = new LoginRequestDTO("test@nexus.com", "password123");
            var user = User.builder()
                    .email("test@nexus.com")
                    .password("encoded_password")
                    .build();

            Jwt mockJwt = mock(Jwt.class);
            when(mockJwt.getTokenValue()).thenReturn("fake-jwt-token");
            when(userRepository.findByEmailOrThrow(request.email())).thenReturn(user);
            when(jwtEncoder.encode(any(JwtEncoderParameters.class))).thenReturn(mockJwt);

            LoginResponseDTO response = authService.login(request);

            assertThat(response.accessToken()).isEqualTo("fake-jwt-token");
            assertThat(response.expiresIn()).isEqualTo(3600L);
            verify(authValidator).validatePassword("password123", "encoded_password");
        }

        @Test
        @DisplayName("Deve lançar exceção quando a validação de senha falhar")
        void shouldThrowExceptionWhenPasswordIsInvalid() {

            var request = new LoginRequestDTO("test@nexus.com", "wrong_pass");
            var user = User.builder().email("test@nexus.com").password("correct_encoded").build();

            when(userRepository.findByEmailOrThrow(anyString())).thenReturn(user);
            doThrow(new RuntimeException("Senha inválida"))
                    .when(authValidator).validatePassword(anyString(), anyString());

            assertThatThrownBy(() -> authService.login(request))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Senha inválida");
        }
    }

    @Nested
    @DisplayName("Testes de Contexto de Autenticação")
    class AuthenticationContextTests {

        @Mock private SecurityContext securityContext;
        @Mock private Authentication authentication;

        @BeforeEach
        void setUp() {
            SecurityContextHolder.setContext(securityContext);
        }

        @Test
        @DisplayName("Deve retornar o e-mail do usuário autenticado no SecurityContext")
        void shouldReturnAuthenticatedEmail() {

            when(securityContext.getAuthentication()).thenReturn(authentication);
            when(authentication.getName()).thenReturn("auth@nexus.com");

            String email = authService.getAuthenticatedEmail();

            assertThat(email).isEqualTo("auth@nexus.com");
        }

        @Test
        @DisplayName("Deve retornar o objeto User completo do usuário autenticado")
        void shouldGetAuthenticatedUser() {

            var user = User.builder().email("auth@nexus.com").build();
            when(securityContext.getAuthentication()).thenReturn(authentication);
            when(authentication.getName()).thenReturn("auth@nexus.com");
            when(userRepository.findByEmailOrThrow("auth@nexus.com")).thenReturn(user);

            User result = authService.getAuthenticatedUser();

            assertThat(result).isNotNull();
            assertThat(result.getEmail()).isEqualTo("auth@nexus.com");
        }
    }
}