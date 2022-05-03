package com.projetogabi.ProjetoGabi.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.projetogabi.ProjetoGabi.model.Usuario;
import com.projetogabi.ProjetoGabi.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping 
	public List<Usuario> findAll(){
		List<Usuario> listaUsuario = repository.findAll();
		return listaUsuario;
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id_usuario){
		return repository.findById(id_usuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Usuario>> GetByTitulo(@PathVariable String  usuario){
		return ResponseEntity.ok(repository.findAllByUsuarioContainingIgnoreCase( usuario));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save( usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id_usuario}")
	public void delete(@PathVariable long id_usuario) {
		repository.deleteById(id_usuario);
	}	
	
}

