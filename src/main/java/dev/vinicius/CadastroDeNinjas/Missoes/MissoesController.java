package dev.vinicius.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Get - requisao para mostrar missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return "missoes listadas com sucesso";
    }

    // Post - requisao para criar missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "missao criada com sucesso";
    }

    // Put - requisao para alterar missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "missao alterada com sucesso";
    }

    // delete - requisao para deletar missoes
    @DeleteMapping("/delete")
    public String deletarMissao(){
        return "missao deletada com sucesso";
    }

}
