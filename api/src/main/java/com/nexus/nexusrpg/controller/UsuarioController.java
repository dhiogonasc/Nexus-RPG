package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.request.UsuarioRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.UsuarioResponseDTO;
import com.nexus.nexusrpg.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Endpoints para gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Criar novo usuário", description = "Cadastra um novo usuário no sistema")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Parameter(description = "Campos de cadastro")
            @Valid @RequestBody UsuarioRequestDTO dto
    ) {

        return ResponseEntity
                .status(CREATED)
                .body(usuarioService.criar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar usuários", description = "Retorna uma lista de todos os usuários cadastrados")
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {

        return ResponseEntity
                .ok(usuarioService.listar());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente pelo ID")
    public ResponseEntity<UsuarioResponseDTO> atualizar(
            @Parameter(description = "ID do usuário")
            @PathVariable Long id,
            @Parameter(description = "Campos atualizados")
            @Valid @RequestBody UsuarioRequestDTO dto
    ) {

        return ResponseEntity
                .ok(usuarioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuário", description = "Remove um usuário do sistema pelo ID")
    @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do usuário")
            @PathVariable Long id
    ) {

        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}