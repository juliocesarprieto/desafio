package br.com.serverBiblioteca.server.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.serverBiblioteca.server.models.Libros;
import br.com.serverBiblioteca.server.repositories.LibrosRepository;


@RestController
@RequestMapping("/api/libros")
public class LibrosService {
	
	@Autowired
	private LibrosRepository librosRepository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody List<Libros> findAll(){
		
		List<Libros> libros = librosRepository.findAll();
		return libros;
	}

}
