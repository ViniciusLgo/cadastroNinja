// Define o pacote onde esta classe está localizada
package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

// Importações necessárias para a persistência de dados e relacionamento com outra entidade
import dev.vinicius.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.awt.*; // ⚠️ Essa importação parece desnecessária e pode ser removida

// Define esta classe como uma entidade do banco de dados
@Entity
// Define que esta entidade será representada na tabela "tb_cadastro" no banco de dados
@Table(name = "tb_cadastro")
public class NinjaModel {

    // Define a chave primária da tabela
    @Id
    // O banco de dados gera o ID automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define os atributos que serão colunas na tabela
    private String nome;
    private String email;
    private int idade;

    // Relacionamento com MissoesModel (Muitos ninjas podem estar em uma mesma missão)
    @ManyToOne
    @JoinColumn(name = "missao_id") // Nome da chave estrangeira no banco
    private MissoesModel missoes;

    // Getters e Setters para acessar e modificar os atributos privados

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Construtor com parâmetros para facilitar a criação de objetos
    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    // Construtor vazio necessário para o JPA/Hibernate
    public NinjaModel() {
    }
}
