package dev.vinicius.CadastroDeNinjas.Ninjas.Controller; // Define o pacote onde a classe está localizada.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Anotação que indica que essa classe é um controlador REST no Spring Boot.
@RestController
// Define o mapeamento base para as requisições HTTP.
@RequestMapping
public class NinjaController { // Declaração da classe Controller.

    // Mapeia requisições HTTP GET para o endpoint "/boasvindas".
    @GetMapping("/boasvindas")
    public String boasVindas() {
        // Retorna uma mensagem de boas-vindas como resposta à requisição.
        return "essa é minha primeira mensaagem nessa roda boas vindo";
    }
}
