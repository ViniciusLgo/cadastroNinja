package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

import dev.vinicius.CadastroDeNinjas.Missoes.MissoesModel;
import dev.vinicius.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.stereotype.Component;

/**
 * Componente responsável por converter entre NinjaDTO e NinjaModel.
 */
@Component
public class NinjaMapper {

    /**
     * Converte um NinjaDTO para um NinjaModel (entidade).
     *
     * @param ninjaDTO objeto de transferência de dados.
     * @return instância de NinjaModel populada com os dados do DTO.
     */
    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes()); // Associa diretamente o objeto Missao

        return ninjaModel;
    }

    /**
     * Converte um NinjaModel (entidade) para um NinjaDTO.
     *
     * @param ninjaModel entidade com os dados salvos.
     * @return DTO contendo os dados prontos para exibição ou transferência.
     */
    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(ninjaModel.getMissoes()); // Pode considerar converter para MissaoDTO futuramente

        return ninjaDTO;
    }
}
