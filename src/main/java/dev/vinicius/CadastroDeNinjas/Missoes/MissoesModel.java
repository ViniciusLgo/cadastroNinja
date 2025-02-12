// Pacote onde essa classe está localizada
package dev.vinicius.CadastroDeNinjas.Missoes;

// Importação das classes necessárias para trabalhar com persistência de dados no JPA
import dev.vinicius.CadastroDeNinjas.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Define esta classe como uma entidade JPA, ou seja, um modelo de banco de dados
@Entity
// Define o nome da tabela correspondente a essa entidade no banco de dados
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    // Define a chave primária da tabela
    @Id
    // Define que o ID será gerado automaticamente pelo banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Define um atributo que será mapeado para uma coluna no banco de dados
    private String nomeDaMissao;

    private String dificuldade;


    // Define um relacionamento OneToMany (uma missão pode ter vários ninjas)
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


}
