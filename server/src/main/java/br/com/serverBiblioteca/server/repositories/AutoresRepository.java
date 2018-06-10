package br.com.serverBiblioteca.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.serverBiblioteca.server.models.Autores;

@Repository
public interface AutoresRepository extends JpaRepository<Autores, Integer>{
	
}
