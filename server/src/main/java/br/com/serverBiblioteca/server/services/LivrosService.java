package br.com.serverBiblioteca.server.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.serverBiblioteca.server.models.Livros;
import br.com.serverBiblioteca.server.repositories.LivrosRepository;


@RestController
@RequestMapping("/api/livros")
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@CrossOrigin(origins="*")
	@GetMapping(produces = "application/json")
	public @ResponseBody List<Livros> findAll(){		
		List<Livros> livros = livrosRepository.findAll();
		return livros;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(consumes="application/json")
	public ResponseEntity<Void> insertLivro(@RequestBody Livros livro ){
		try{
			livrosRepository.save(livro);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(consumes="application/json")
	public ResponseEntity<Void> atualizarlivro(@RequestBody Livros livro){
		try{
			livrosRepository.save(livro);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping(path="/{idLivros}")
	public ResponseEntity<Void> delete(@PathVariable Integer idLivros){
		try{
			livrosRepository.deleteById(idLivros);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
		return ResponseEntity.noContent().build();
	}
	

}
