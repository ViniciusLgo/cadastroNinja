package dev.vinicius.CadastroDeNinjas.Ninjas.Controller; // Define o pacote onde a classe está localizada.
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotação que indica que essa classe é um controlador REST no Spring Boot.
@RestController
// Define o mapeamento base para as requisições HTTP.
@RequestMapping("/ninjas")
public class NinjaController { // Declaração da classe Controller.

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Mapeia requisições HTTP GET para o endpoint "/boasvindas".
    @GetMapping("/boasvindas")
    public String boasVindas() {
        // Retorna uma mensagem de boas-vindas como resposta à requisição.
        return "essa é minha primeira mensaagem nessa roda boas vindo";
    }

    // add ninja(create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja) ;
    }

    // procurar por id (create )

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // mostrar os ninjas por ID  ( read)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //alterar dados dos ninjas(update)
    @PutMapping("/alterarID")
    public String alterarNinjaId(){
        return "Alterar Ninjas por ID";
    }

    // deletar ninja (delete)
    @DeleteMapping("/deletarID")
    public String deletarNinjaId(){
        return "Deletar Ninjas por ID";
    }

}

