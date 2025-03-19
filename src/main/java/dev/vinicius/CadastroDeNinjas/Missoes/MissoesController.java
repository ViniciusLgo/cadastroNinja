package dev.vinicius.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// Define que esta classe é um controlador REST
@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // Torna o serviço final, pois ele não será alterado após a injeção
    private final MissoesService missoesService;

    // Injeta a dependência de MissoesService no construtor
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Método GET para listar todas as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // Método POST para criar uma nova missão
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes) {
        return missoesService.criarMissao(missoes);
    }

    // Método PUT para alterar uma missão - deveria receber um ID e um objeto atualizado
    @PutMapping("/alterar/{id}")
    public String alterarMissao() {
        return "alterado com sucesso";
    }

    // Método DELETE para deletar uma missão pelo ID
    @DeleteMapping("/delete/{id}") // Adicionando o {id} na URL
    public void deletarMissaoId(@PathVariable Long id) {
        missoesService.deletarMissoesPorId(id);
    }
}
