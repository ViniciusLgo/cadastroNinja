package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

import dev.vinicius.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.vinicius.CadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(
            summary = "Mensagem de boas-vindas",
            description = "Rota de teste para verificar o funcionamento da API."
    )
    public ResponseEntity<String> boasVindas() {
        return ResponseEntity.ok("Essa é minha primeira mensagem nessa rota, bem-vindo!");
    }

    @PostMapping("/criar")
    @Operation(
            summary = "Criar um novo ninja",
            description = "Cria um novo ninja no sistema com nome, idade, e-mail e rank."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content)
    })
    public ResponseEntity<String> criarNinja(
            @RequestBody(
                    description = "Dados do ninja a ser criado",
                    required = true,
                    content = @Content(schema = @Schema(implementation = NinjaDTO.class))
            )
            @org.springframework.web.bind.annotation.RequestBody NinjaDTO ninja
    ) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso! Nome: " + novoNinja.getNome() + " | ID: " + novoNinja.getId());
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Listar todos os ninjas",
            description = "Retorna uma lista com todos os ninjas cadastrados no sistema."
    )
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
    @Operation(
            summary = "Buscar ninja por ID",
            description = "Retorna os dados de um ninja específico com base no ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado", content = @Content)
    })
    public ResponseEntity<?> listarNinjasPorId(
            @Parameter(description = "ID do ninja a ser consultado") @PathVariable Long id
    ) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(
            summary = "Atualizar ninja por ID",
            description = "Atualiza os dados de um ninja existente com base no ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado", content = @Content)
    })
    public ResponseEntity<?> alterarNinjaId(
            @Parameter(description = "ID do ninja que será atualizado") @PathVariable Long id,
            @RequestBody(
                    description = "Dados atualizados do ninja",
                    required = true,
                    content = @Content(schema = @Schema(implementation = NinjaDTO.class))
            )
            @org.springframework.web.bind.annotation.RequestBody NinjaDTO ninjaAtualizado
    ) {
        NinjaDTO atualizado = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado para atualização.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deletar ninja por ID",
            description = "Remove um ninja do sistema com base no ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado", content = @Content)
    })
    public ResponseEntity<String> deletarNinjaId(
            @Parameter(description = "ID do ninja a ser deletado") @PathVariable Long id
    ) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso! ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado para deletar.");
        }
    }
}
