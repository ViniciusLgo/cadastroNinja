package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();

    }

    // Listas todos os ninjas por ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> NinjaPorId = ninjaRepository.findById(id);
        return NinjaPorId.orElse(null);
    }

    // criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

    // deletar ninja por Id
    public void deletarNinjaPorId(Long id){
       ninjaRepository.deleteById(id);
    }

    // atualizar ninja por id
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;

    }


}
