package dev.vinicius.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    // Torna o repositório final, pois não será alterado após a injeção
    private final MissoesRepository missoesRepository;

    // Construtor com injeção de dependência do repositório
    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Método para listar todas as missões
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Método para listar uma missão por ID
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null); // Retorna null se a missão não for encontrada
    }

    // Método para criar uma nova missão
    public MissoesModel criarMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    // Método para deletar uma missão por ID e retornar a missão excluída
    public MissoesModel deletarMissoesPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);

        if (missaoPorId.isPresent()) {
            missoesRepository.deleteById(id); // Deleta a missão do banco de dados
            return missaoPorId.get(); // Retorna a missão deletada
        }

        return null; // Retorna null caso a missão não seja encontrada
    }
}
