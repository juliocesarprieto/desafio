package br.com.serverBiblioteca.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.serverBiblioteca.server.models.Editales;
import br.com.serverBiblioteca.server.repositories.EditalesRepository;


@RestController
@RequestMapping("/api/editales")
public class EditalesService {

	@Autowired
	private EditalesRepository editalesRepository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody List<Editales> findAll(){
		
		List<Editales> editales = editalesRepository.findAll();
		return editales;
	}
	
}
