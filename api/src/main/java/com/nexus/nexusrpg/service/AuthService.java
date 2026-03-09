package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.LoginDTO;
import com.nexus.nexusrpg.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por gerenciar a autenticação de usuários.
 * Este serviço atua como uma ponte entre a camada de controle e o framework
 * de segurança, delegando a validação de credenciais ao {@link AuthenticationManager}
 * e a geração de tokens ao {@link TokenService}.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    /**
     * Autentica um usuário com base nas credenciais fornecidas e gera um token JWT.
     *
     * @param dto Objeto contendo o e-mail e a senha do usuário.
     * @return Uma {@link String} contendo o token JWT gerado para a sessão.
     * @throws org.springframework.security.core.AuthenticationException
     * caso as credenciais sejam inválidas ou o usuário não possa ser autenticado.
     */
    public String autenticar(LoginDTO dto) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        Authentication auth = authenticationManager.authenticate(authToken);

        return tokenService.gerarToken(auth.getName());
    }
}