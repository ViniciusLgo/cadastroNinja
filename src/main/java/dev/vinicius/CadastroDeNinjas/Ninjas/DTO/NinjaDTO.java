package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

import dev.vinicius.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) da entidade Ninja.
 * Usado para transferir dados entre a API e a camada de serviço.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;                // Identificador único do ninja
    private String nome;            // Nome do ninja
    private String email;           // E-mail de contato
    private int idade;              // Idade do ninja
    private String imgUrl;          // URL da imagem do ninja (avatar)
    private String rank;            // Rank do ninja (ex: Genin, Chunin, Jounin)
    private MissoesModel missoes;   // Missão atribuída (pode ser convertido para MissaoDTO futuramente)

}
