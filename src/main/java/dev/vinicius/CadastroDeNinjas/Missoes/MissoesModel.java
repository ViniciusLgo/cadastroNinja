package dev.vinicius.CadastroDeNinjas.Missoes;

import dev.vinicius.CadastroDeNinjas.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeDaMissao;
    private String dificuldade;

    private NinjaModel ninja;


    public MissoesModel(long id, String nomeDaMissao, String dificuldade, NinjaModel ninja) {
        this.id = id;
        this.nomeDaMissao = nomeDaMissao;
        this.dificuldade = dificuldade;
        this.ninja = ninja;
    }

    public MissoesModel() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }
}

