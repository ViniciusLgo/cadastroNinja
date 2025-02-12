// Pacote onde essa classe está localizada
package dev.vinicius.CadastroDeNinjas.Missoes;

// Importação das classes necessárias para trabalhar com persistência de dados no JPA
import dev.vinicius.CadastroDeNinjas.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

// Define esta classe como uma entidade JPA, ou seja, um modelo de banco de dados
@Entity
// Define o nome da tabela correspondente a essa entidade no banco de dados
@Table(name = "tb_missoes")
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

    // Construtor da classe para criar um objeto MissoesModel com valores específicos
    public MissoesModel(long id, String nomeDaMissao, String dificuldade) {
        this.id = id;
        this.nomeDaMissao = nomeDaMissao;
        this.dificuldade = dificuldade;
    }

    // Construtor vazio necessário para o JPA (Hibernate exige um construtor padrão)
    public MissoesModel() {
    }

    // Métodos getters e setters para acessar e modificar os atributos privados


}
