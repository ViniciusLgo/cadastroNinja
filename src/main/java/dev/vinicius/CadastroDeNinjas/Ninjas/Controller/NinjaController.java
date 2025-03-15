package dev.vinicius.CadastroDeNinjas.Ninjas.Controller; // Define o pacote onde a classe está localizada.
import org.springframework.web.bind.annotation.*;

// Anotação que indica que essa classe é um controlador REST no Spring Boot.
@RestController
// Define o mapeamento base para as requisições HTTP.
@RequestMapping("/ninjas")
public class NinjaController { // Declaração da classe Controller.

    // Mapeia requisições HTTP GET para o endpoint "/boasvindas".
    @GetMapping("/boasvindas")
    public String boasVindas() {
        // Retorna uma mensagem de boas-vindas como resposta à requisição.
        return "essa é minha primeira mensaagem nessa roda boas vindo";
    }

    // add ninja(create)
    @PostMapping("/criar")
    public String criarNinja() {
        return "ninja criado";
    }

    // procurar por id (create )

    // listar os ninjas  ( read)
    @GetMapping("/listar")
    public String listarTodosOsNinjas(){
        return "listar Ninjas";
    }
// mostrar os ninjas por ID  ( read)
    @GetMapping("/listarId")
    public String listarTodosOsNinjasPorId(){
        return "Listar Ninjas por ID";
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

