package dev.vinicius.CadastroDeNinjas.Missoes.Service;

import dev.vinicius.CadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.vinicius.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio relacionada à entidade Missão.
 */
@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    /**
     * Lista todas as missões cadastradas no sistema.
     *
     * @return lista de Missões.
     */
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    /**
     * Busca uma missão pelo ID.
     *
     * @param id identificador da missão.
     * @return Missao se encontrada, senão null.
     */
    public MissoesModel listarMissoesPorId(Long id) {
        return missoesRepository.findById(id).orElse(null);
    }

    /**
     * Cria uma nova missão no banco de dados.
     *
     * @param missoesModel objeto com os dados da missão.
     * @return Missão criada.
     */
    public MissoesModel criarMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    /**
     * Deleta uma missão existente e retorna seus dados.
     *
     * @param id identificador da missão.
     * @return missão deletada, ou null se não encontrada.
     */
    public MissoesModel deletarMissoesPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);

        if (missaoPorId.isPresent()) {
            missoesRepository.deleteById(id);
            return missaoPorId.get();
        }

        return null;
    }

    /**
     * Atualiza os dados de uma missão.
     *
     * @param id         identificador da missão.
     * @param novaMissao dados atualizados.
     * @return missão atualizada ou null se não encontrada.
     */
    public MissoesModel atualizarMissao(Long id, MissoesModel novaMissao) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);

        if (missaoExistente.isPresent()) {
            MissoesModel missao = missaoExistente.get();
            missao.setNomeDaMissao(novaMissao.getNomeDaMissao());
            missao.setDificuldade(novaMissao.getDificuldade());

            return missoesRepository.save(missao);
        }

        return null;
    }

    /**
     * Retorna uma missão sem alterá-la (usado no DELETE e GET por ID).
     *
     * @param id ID da missão.
     * @return missão encontrada ou null.
     */
    public MissoesModel buscarPorId(Long id) {
        return missoesRepository.findById(id).orElse(null);
    }
}
