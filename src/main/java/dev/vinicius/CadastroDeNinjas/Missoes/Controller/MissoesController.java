package dev.vinicius.CadastroDeNinjas.Missoes.Controller;

import dev.vinicius.CadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.vinicius.CadastroDeNinjas.Missoes.Service.MissoesService;
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
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Listar todas as missões",
            description = "Retorna uma lista com todas as missões cadastradas no sistema."
    )
    public ResponseEntity<List<MissoesModel>> listarMissoes() {
        List<MissoesModel> lista = missoesService.listarMissoes();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/criar")
    @Operation(
            summary = "Criar uma nova missão",
            description = "Cadastra uma nova missão com título, descrição e nível."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    public ResponseEntity<MissoesModel> criarMissao(
            @RequestBody(
                    description = "Dados da missão a ser criada",
                    required = true,
                    content = @Content(schema = @Schema(implementation = MissoesModel.class))
            )
            @org.springframework.web.bind.annotation.RequestBody MissoesModel missoes
    ) {
        MissoesModel nova = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @PutMapping("/alterar/{id}")
    @Operation(
            summary = "Atualizar missão por ID",
            description = "Atualiza uma missão existente com base no ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada", content = @Content)
    })
    public ResponseEntity<?> alterarMissao(
            @Parameter(description = "ID da missão a ser atualizada") @PathVariable Long id,
            @RequestBody(
                    description = "Dados atualizados da missão",
                    required = true,
                    content = @Content(schema = @Schema(implementation = MissoesModel.class))
            )
            @org.springframework.web.bind.annotation.RequestBody MissoesModel atualizada
    ) {
        MissoesModel alterada = missoesService.atualizarMissao(id, atualizada);
        if (alterada != null) {
            return ResponseEntity.ok(alterada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID " + id + " não encontrada para atualização.");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Deletar missão por ID",
            description = "Remove uma missão com base no ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada", content = @Content)
    })
    public ResponseEntity<String> deletarMissaoId(
            @Parameter(description = "ID da missão a ser deletada") @PathVariable Long id
    ) {
        if (missoesService.buscarPorId(id) != null) {
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso! ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID " + id + " não encontrada para deletar.");
        }
    }
}
