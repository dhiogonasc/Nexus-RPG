package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.UsuarioRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.UsuarioResponseDTO;
import com.nexus.nexusrpg.model.entity.Usuario;
import com.nexus.nexusrpg.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(dto.senha())
                .build();

        Usuario u = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                u.getId(),
                u.getNome(),
                u.getEmail(),
                u.getDataCriacao()
        );
    }

    public List<UsuarioResponseDTO> listarTodos() {

        return usuarioRepository.findAll().stream()
                .map(u -> new UsuarioResponseDTO(
                        u.getId(),
                        u.getNome(),
                        u.getEmail(),
                        u.getDataCriacao())
                )
                .toList();
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNome(dto.nome());

        Usuario u = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                u.getId(),
                u.getNome(),
                u.getEmail(),
                u.getDataCriacao()
        );
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}