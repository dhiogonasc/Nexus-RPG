package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.request.UsuarioRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.UsuarioResponseDTO;
import com.nexus.nexusrpg.security.TokenService;
import com.nexus.nexusrpg.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
    
    final private UsuarioService usuarioService;
    final private TokenService tokenService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioRequestDTO dto) {

        UsuarioResponseDTO usuarioCriado = usuarioService.criar(dto);

        String token = tokenService.gerarToken(dto.email());

        return ResponseEntity.status(CREATED).body(new UsuarioResponseDTO(
                usuarioCriado.id(),
                usuarioCriado.nome(),
                usuarioCriado.email(),
                usuarioCriado.dataCriacao(),
                token
        ));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {

        return ResponseEntity
                .ok(usuarioService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO dto) {

        return ResponseEntity
                .ok(usuarioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}