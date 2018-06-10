package br.com.serverBiblioteca.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.serverBiblioteca.server.models.Autores;
import br.com.serverBiblioteca.server.repositories.AutoresRepository;


@RestController
@RequestMapping("/api/autores")
public class AutoresService {

	@Autowired
	private AutoresRepository autorRepository;


	@GetMapping(produces = "application/json")
	public @ResponseBody List<Autores> findAll(){

		List<Autores> autores = autorRepository.findAll();

		return autores;
	}

}
