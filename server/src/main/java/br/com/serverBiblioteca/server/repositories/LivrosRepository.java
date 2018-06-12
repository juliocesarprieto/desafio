package br.com.serverBiblioteca.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Livros l WHERE l.categoria.idCategorias =:idCategoria")
	void deleteAllByIdCategoria(@Param("idCategoria") Integer idCategoria);
	
	
}
