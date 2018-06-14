package br.com.serverBiblioteca.server.resources;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api Rest livros")
@RestController
@RequestMapping("/api/livros")
public class LivrosResource {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@ApiOperation(value = "retornar lista de livros")
	@CrossOrigin(origins="*")
	@GetMapping(produces = "application/json")
	public @ResponseBody List<Livros> findAll(){		
		List<Livros> livros = livrosRepository.findAll();		
		return livros;
	}
	
	@ApiOperation(value = "retorna lista de categorias filtrada pelo criterio")
	@CrossOrigin(origins="*")
	@GetMapping(path="/{criteria}", produces = "application/json")
	public @ResponseBody List<Livros> getByCriteria(@PathVariable String criteria){
		List<Livros> libros = livrosRepository.getByCriteria(criteria);
		return libros;
	}
	
	@ApiOperation(value = "inserir novo livro")
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
	
	@ApiOperation(value = "atualizar livro")
	@CrossOrigin(origins="*")
	@PutMapping(consumes="application/json")
	public ResponseEntity<Void> atualizarLivro(@RequestBody Livros livro){
		try{
			livrosRepository.save(livro);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "remover livro")
	@CrossOrigin(origins="*")
	@DeleteMapping(path="/{idLivros}")
	public ResponseEntity<Void> deleteLivro(@PathVariable Integer idLivros){
		try{
			livrosRepository.deleteById(idLivros);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
		return ResponseEntity.noContent().build();
	}
	

}
