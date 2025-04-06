package dev.vinicius.CadastroDeNinjas.Ninjas.Service;

import dev.vinicius.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.vinicius.CadastroDeNinjas.Ninjas.Mapper.NinjaMapper;
import dev.vinicius.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.vinicius.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela lógica de negócio relacionada à entidade Ninja.
 */
@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    /**
     * Lista todos os ninjas cadastrados no sistema.
     *
     * @return lista de NinjaDTOs.
     */
    public List<NinjaDTO> listarNinjas() {
        return ninjaRepository.findAll()
                .stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    /**
     * Busca um ninja pelo ID.
     *
     * @param id identificador do ninja.
     * @return NinjaDTO se encontrado, senão null.
     */
    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    /**
     * Cria um novo ninja no banco de dados.
     *
     * @param ninjaDTO dados do ninja a ser criado.
     * @return NinjaDTO criado.
     */
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        NinjaModel salvo = ninjaRepository.save(ninja);
        return ninjaMapper.map(salvo);
    }

    /**
     * Deleta um ninja pelo ID.
     *
     * @param id identificador do ninja.
     */
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    /**
     * Atualiza os dados de um ninja existente.
     *
     * @param id        identificador do ninja.
     * @param ninjaDTO  dados atualizados.
     * @return NinjaDTO atualizado ou null se não encontrado.
     */
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninja = ninjaExistente.get();
            // Atualiza apenas os campos permitidos
            ninja.setNome(ninjaDTO.getNome());
            ninja.setRank(ninjaDTO.getRank());
            ninja.setEmail(ninjaDTO.getEmail());
            ninja.setIdade(ninjaDTO.getIdade());
            ninja.setImgUrl(ninjaDTO.getImgUrl());
            ninja.setMissoes(ninjaDTO.getMissoes());

            NinjaModel atualizado = ninjaRepository.save(ninja);
            return ninjaMapper.map(atualizado);
        }
        return null;
    }
}
