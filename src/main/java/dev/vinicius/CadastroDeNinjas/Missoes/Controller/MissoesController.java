package dev.vinicius.CadastroDeNinjas.Missoes.Controller;

import dev.vinicius.CadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.vinicius.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável pelos endpoints da entidade Missão.
 */
@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    /**
     * Endpoint GET para listar todas as missões.
     *
     * @return lista de Missões.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesModel>> listarMissoes() {
        List<MissoesModel> lista = missoesService.listarMissoes();
        return ResponseEntity.ok(lista);
    }

    /**
     * Endpoint POST para criar uma nova missão.
     *
     * @param missoes dados da missão.
     * @return missão criada.
     */
    @PostMapping("/criar")
    public ResponseEntity<MissoesModel> criarMissao(@RequestBody MissoesModel missoes) {
        MissoesModel nova = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    /**
     * Endpoint PUT para atualizar uma missão pelo ID.
     *
     * @param id      ID da missão a ser atualizada.
     * @param atualizada objeto com dados novos da missão.
     * @return missão atualizada ou mensagem de erro.
     */
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesModel atualizada) {
        MissoesModel alterada = missoesService.atualizarMissao(id, atualizada);
        if (alterada != null) {
            return ResponseEntity.ok(alterada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID " + id + " não encontrada para atualização.");
        }
    }

    /**
     * Endpoint DELETE para excluir uma missão pelo ID.
     *
     * @param id ID da missão.
     * @return mensagem de sucesso ou erro.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarMissaoId(@PathVariable Long id) {
        if (missoesService.buscarPorId(id) != null) {
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso! ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID " + id + " não encontrada para deletar.");
        }
    }
}
