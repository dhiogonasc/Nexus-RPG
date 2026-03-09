package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.request.UsuarioRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.UsuarioResponseDTO;
import com.nexus.nexusrpg.mapper.UsuarioMapper;
import com.nexus.nexusrpg.model.entity.Usuario;
import com.nexus.nexusrpg.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        Usuario usuario = usuarioMapper.toEntity(dto);

        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        Usuario salvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(salvo);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(dto.nome());
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}