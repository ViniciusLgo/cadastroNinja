package dev.vinicius.CadastroDeNinjas.Ninjas.Model;

import dev.vinicius.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa o cadastro de ninjas no banco de dados.
 */
@Entity
@Table(name = "tb_cadastro") // Nome da tabela no banco de dados
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    // Chave primária da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Nome do ninja
    @Column(name = "nome")
    private String nome;

    // E-mail do ninja (único)
    @Column(unique = true)
    private String email;

    // URL da imagem do ninja
    @Column(name = "img_url")
    private String imgUrl;

    // Rank do ninja (Ex: Genin, Chunin, Jounin)
    @Column(name = "rank")
    private String rank;

    // Idade do ninja
    @Column(name = "idade")
    private int idade;

    /**
     * Relacionamento ManyToOne com Missao.
     * Muitos ninjas podem estar vinculados à mesma missão.
     */
    @ManyToOne
    @JoinColumn(name = "missao_id") // Nome da chave estrangeira no banco
    private MissoesModel missoes;
}
