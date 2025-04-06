package dev.vinicius.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório responsável pelas operações de persistência da entidade Missão.
 * Estende JpaRepository para fornecer os métodos CRUD automaticamente.
 */
@Repository
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
    // Métodos customizados podem ser adicionados aqui no futuro, se necessário.
}
