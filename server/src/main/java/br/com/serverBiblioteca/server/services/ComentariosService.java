package br.com.serverBiblioteca.server.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.serverBiblioteca.server.models.Comentarios;
import br.com.serverBiblioteca.server.repositories.ComentariosRepository;


@RestController
@RequestMapping("/api/comentarios")
public class ComentariosService {
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody List<Comentarios> findAll(){
		
		List<Comentarios> comentarios = comentariosRepository.findAll();
		return comentarios;
	}

}
