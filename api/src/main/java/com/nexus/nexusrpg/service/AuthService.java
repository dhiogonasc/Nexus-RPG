package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por orquestrar o fluxo de autenticação de usuários no sistema.
 * * <p>Este componente atua como uma camada de fachada entre o {@code Controller} e os
 * mecanismos de segurança do Spring, sendo responsável por:</p>
 * <ul>
 * <li>Validar as credenciais fornecidas contra o banco de dados via {@link AuthenticationManager}.</li>
 * <li>Gerar um token de acesso (JWT) após a autenticação bem-sucedida via {@link TokenService}.</li>
 * </ul>
 * * <p>O fluxo de autenticação segue a arquitetura de {@code AuthenticationProvider} do Spring Security,
 * onde a tentativa de autenticação lança exceções caso as credenciais sejam inválidas.</p>
 *
 * @see org.springframework.security.authentication.AuthenticationManager
 * @see com.nexus.nexusrpg.security.TokenService
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    /**
     * Realiza a autenticação do usuário e emite um token JWT para a sessão.
     *
     * <p>Este método converte as credenciais do DTO em um {@link UsernamePasswordAuthenticationToken},
     * aciona o {@link AuthenticationManager} para validar a identidade e, em caso de sucesso,
     * utiliza o {@link TokenService} para a criação do token.</p>
     *
     * @param dto Objeto contendo o e-mail e a senha informados pelo usuário.
     * @return Um {@link LoginResponseDTO} contendo o token JWT gerado.
     * @throws org.springframework.security.core.AuthenticationException se as credenciais
     * estiverem incorretas ou a conta estiver bloqueada/inativa.
     */
    public LoginResponseDTO autenticar(LoginRequestDTO dto) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        Authentication auth = authenticationManager.authenticate(authToken);

        return new LoginResponseDTO(tokenService.gerarToken(auth.getName()));
    }
}