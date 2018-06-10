package br.com.serverBiblioteca.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.serverBiblioteca.server.models.Editales;

@Repository
public interface EditalesRepository extends JpaRepository<Editales, Integer> {

}
