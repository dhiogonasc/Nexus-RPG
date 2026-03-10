package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.response.UsuarioResponseDTO;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.repository.UserRepository;
import com.nexus.nexusrpg.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Serviço responsável pela lógica de negócio relacionada aos usuários.
 * Gerencia o ciclo de vida dos usuários, incluindo criação, listagem,
 * atualização e deleção, garantindo a segurança das senhas.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private User getById(Long id){
        return userRepository.findByIdOrThrow(id);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }
}