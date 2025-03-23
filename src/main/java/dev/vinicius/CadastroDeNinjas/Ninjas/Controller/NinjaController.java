package dev.vinicius.CadastroDeNinjas.Ninjas.Controller; // Define o pacote onde a classe está localizada.
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotação que indica que essa classe é um controlador REST no Spring Boot.
@RestController
@RequestMapping("/ninjas") // Define o mapeamento base para as requisições HTTP.
public class NinjaController {

    // Torna o serviço final para garantir que não será alterado após a injeção
    private final NinjaService ninjaService;

    // Injeta o serviço pelo construtor


    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Método GET para exibir uma mensagem de boas-vindas
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota, bem-vindo!";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
        public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
            return ninjaService.criarNinja(ninja);
        }

    // Método GET para listar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Método GET para buscar um ninja pelo ID (read)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    // Método PUT para atualizar um ninja (update) - NÃO ALTERADO CONFORME SOLICITAÇÃO
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Método DELETE para deletar um ninja pelo ID
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }
}
