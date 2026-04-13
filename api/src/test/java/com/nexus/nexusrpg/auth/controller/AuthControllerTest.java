package com.nexus.nexusrpg.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexus.nexusrpg.domain.auth.controller.AuthController;
import com.nexus.nexusrpg.domain.auth.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.domain.auth.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.domain.auth.service.AuthService;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private AuthService authService;

    @MockitoBean
    private UserRepository userRepository;

    @Nested
    class LoginTests {

        @Test
        void shouldLoginSuccessfully() throws Exception {
            var request = new LoginRequestDTO("user@nexus.com", "password123");
            var response = new LoginResponseDTO("jwt-token", 3600L, Instant.now());

            when(authService.login(any(LoginRequestDTO.class))).thenReturn(response);

            mockMvc.perform(post("/auth/login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.accessToken").value("jwt-token"));
        }

        @Test
        void shouldFailWhenEmailIsInvalid() throws Exception {
            var request = new LoginRequestDTO("email-errado", "123456");

            mockMvc.perform(post("/auth/login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());

            verifyNoInteractions(authService);
        }
    }

    @Nested
    class RegisterTests {

        @Test
        void shouldRegisterUser() throws Exception {
            var request = new RegisterRequestDTO("PlayerOne", "player@nexus.com", "secret123");

            mockMvc.perform(post("/auth/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isCreated());

            verify(authService).register(any(RegisterRequestDTO.class));
        }

        @Test
        void shouldFailWhenUsernameTooShort() throws Exception {
            var request = new RegisterRequestDTO("Al", "valid@email.com", "password123");

            mockMvc.perform(post("/auth/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }
    }
}