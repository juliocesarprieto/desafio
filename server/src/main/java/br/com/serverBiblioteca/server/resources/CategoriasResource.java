package br.com.serverBiblioteca.server.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.serverBiblioteca.server.models.Categorias;
import br.com.serverBiblioteca.server.repositories.CategoriasRepository;
import br.com.serverBiblioteca.server.repositories.LivrosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api Rest Categorias")
@RestController
@RequestMapping("/api/categorias")
public class CategoriasResource {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@ApiOperation(value = "Retornar lista das categorias")
	@CrossOrigin(origins="*")
	@GetMapping(produces = "application/json")
	public @ResponseBody List<Categorias> findAll(){		
		List<Categorias> categorias = categoriasRepository.findAll();		
		return categorias;
	}
	
	@ApiOperation(value = "Inserir nova categoria")
	@CrossOrigin(origins="*")
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Void> insert(@RequestBody Categorias categoria){
		categoriasRepository.save(categoria);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Atualizar categoria")
	@CrossOrigin(origins="*")
	@PutMapping(consumes = "application/json")
	public ResponseEntity<Void> atualizar(@RequestBody Categorias categoria){
		categoriasRepository.save(categoria);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remover categoria")
	@CrossOrigin(origins="*")
	@DeleteMapping(path="/{idCategoria}")
	public ResponseEntity<Void> remover(@PathVariable Integer idCategoria){
		
		livrosRepository.deleteAllByIdCategoria(idCategoria);
		categoriasRepository.deleteById(idCategoria);		
		return ResponseEntity.noContent().build();
	}

}
