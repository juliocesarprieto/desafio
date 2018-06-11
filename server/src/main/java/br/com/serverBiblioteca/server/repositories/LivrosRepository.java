package br.com.serverBiblioteca.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.serverBiblioteca.server.models.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer>{	

	@Query("SELECT l FROM Livros l "
			+ "LEFT JOIN FETCH l.categoria c "
			+ "WHERE l.tituloLivro LIKE CONCAT('%',:criteria,'%') "
			+ "OR l.descricaoLivro LIKE CONCAT('%',:criteria,'%') "
			+ "OR l.autor LIKE CONCAT('%',:criteria,'%') "
			+ "OR c.descricaoCategoria LIKE CONCAT('%',:criteria,'%')")
	List<Livros> getByCriteria(@Param("criteria") String criteria);
}
