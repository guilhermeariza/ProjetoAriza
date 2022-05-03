package com.projetogabi.ProjetoGabi.controller;

//usuario quer fazer e resposta do usuario

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

import com.projetogabi.ProjetoGabi.model.Professor;
import com.projetogabi.ProjetoGabi.repository.ProfessorRepository;

@RestController
@RequestMapping(value = "/pessoajuridica")
@CrossOrigin("*") // indica que recebe requisição de quaqlquer outra parte do codigo
public class ProfessorController {

	@Autowired
	private ProfessorRepository repository;

	@GetMapping
	public ResponseEntity<List<Professor>> getAll(){
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Professor> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Professor> post(@RequestBody Professor pessoaJuridica) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoaJuridica));
	}

	@PutMapping
	public ResponseEntity<Professor> put(@RequestBody Professor pessoaJuridica) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoaJuridica));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}