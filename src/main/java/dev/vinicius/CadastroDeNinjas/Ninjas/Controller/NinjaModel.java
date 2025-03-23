// Define o pacote onde esta classe está localizada
package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

// Importações necessárias para a persistência de dados e relacionamento com outra entidade
import dev.vinicius.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Define esta classe como uma entidade do banco de dados
@Entity
// Define que esta entidade será representada na tabela "tb_cadastro" no banco de dados
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

    // Define a chave primária da tabela
    @Id
    // O banco de dados gera o ID automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Define os atributos que serão colunas na tabela
    @Column(name = "nome")
    private String nome;


    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    // Relacionamento com MissoesModel (Muitos ninjas podem estar em uma mesma missão)
    @ManyToOne
    @JoinColumn(name = "missao_id") // Nome da chave estrangeira no banco
    private MissoesModel missoes;


}
