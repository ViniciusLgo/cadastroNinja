package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

import dev.vinicius.CadastroDeNinjas.Ninjas.Controller.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório responsável pelas operações de persistência da entidade Ninja.
 * Estende JpaRepository para herdar métodos prontos de CRUD.
 */
@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
    // Você pode adicionar métodos customizados aqui no futuro, se precisar.
}
