package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

import dev.vinicius.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.vinicius.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável pelos endpoints da entidade Ninja.
 */
@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    /**
     * Construtor com injeção de dependência do serviço.
     */
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    /**
     * Endpoint de teste para confirmar funcionamento da API.
     */
    @GetMapping("/boasvindas")
    public ResponseEntity<String> boasVindas() {
        return ResponseEntity.ok("Essa é minha primeira mensagem nessa rota, bem-vindo!");
    }

    /**
     * Cria um novo ninja.
     *
     * @param ninja DTO com os dados do ninja a ser criado.
     * @return mensagem com confirmação da criação.
     */
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso! Nome: " + novoNinja.getNome() + " | ID: " + novoNinja.getId());
    }

    /**
     * Lista todos os ninjas cadastrados.
     *
     * @return lista de ninjas.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> lista = ninjaService.listarNinjas();
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca um ninja pelo ID.
     *
     * @param id identificador do ninja.
     * @return ninja encontrado ou mensagem de erro.
     */
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        }
    }

    /**
     * Atualiza um ninja existente com base no ID.
     *
     * @param id identificador do ninja.
     * @param ninjaAtualizado dados atualizados do ninja.
     * @return ninja atualizado ou mensagem de erro.
     */
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO atualizado = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado para atualização.");
        }
    }

    /**
     * Deleta um ninja com base no ID.
     *
     * @param id identificador do ninja.
     * @return mensagem de sucesso ou erro.
     */
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso! ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado para deletar.");
        }
    }
}
