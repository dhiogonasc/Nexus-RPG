package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.UsuarioRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.UsuarioResponseDTO;
import com.nexus.nexusrpg.mapper.UsuarioMapper;
import com.nexus.nexusrpg.model.entity.Usuario;
import com.nexus.nexusrpg.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Serviço responsável pela lógica de negócio relacionada aos usuários.
 * Gerencia o ciclo de vida dos usuários, incluindo criação, listagem,
 * atualização e deleção, garantindo a segurança das senhas.
 */
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * Cria um novo usuário no sistema.
     * * @param dto Objeto contendo os dados do novo usuário (nome, email, senha).
     * @return {@link UsuarioResponseDTO} contendo os dados do usuário criado.
     */
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    /**
     * Lista todos os usuários cadastrados.
     * * @return Uma {@link List} de {@link UsuarioResponseDTO} com todos os registros.
     */
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }

    /**
     * Atualiza os dados de um usuário existente.
     * * @param id Identificador único do usuário.
     * @param dto Objeto contendo os novos dados para atualização.
     * @return {@link UsuarioResponseDTO} atualizado.
     * @throws ResponseStatusException caso o usuário não seja encontrado.
     */
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = this.buscarPorId(id);
        usuario.setNome(dto.nome());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    /**
     * Remove um usuário do sistema de forma permanente.
     * * @param id Identificador único do usuário a ser removido.
     * @throws ResponseStatusException caso o usuário não seja encontrado.
     */
    public void deletar(Long id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }

    /**
     * Busca um usuário pelo ID ou lança uma exceção caso não exista.
     * * @param id Identificador do usuário.
     * @return O objeto {@link Usuario} encontrado.
     * @throws ResponseStatusException com status 404 caso o ID seja inválido.
     */
    private Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }
}