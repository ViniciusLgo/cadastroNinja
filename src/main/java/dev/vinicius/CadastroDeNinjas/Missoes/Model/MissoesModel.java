package dev.vinicius.CadastroDeNinjas.Missoes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.vinicius.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Entidade que representa a tabela de missões no banco de dados.
 */
@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissoesModel {

    /** Chave primária da missão */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Nome da missão */
    private String nomeDaMissao;

    /** Nível de dificuldade da missão */
    private String dificuldade;

    /**
     * Relacionamento OneToMany com NinjaModel.
     * Uma missão pode ter vários ninjas atribuídos a ela.
     * A anotação @JsonIgnore evita recursividade infinita ao serializar.
     */
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;
}
