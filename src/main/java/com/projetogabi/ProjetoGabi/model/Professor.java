package com.projetogabi.ProjetoGabi.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String email;
	
    @NotNull
    @Size(min = 18, max = 18)
    private String cpf;
     
    @OneToOne
    @JsonIgnoreProperties("pessoaJuridica")
	private Usuario usuario;
	
    @NotNull
	private String nome;
	
    @NotNull
	private String anoEscolar;
	
    @NotNull
	private String disciplina;
	
    @NotNull
	private String disponibilidade;
	
    @NotNull
	private String telefoneDeContato;
	
    @NotNull
	private String emailDeContato;
    
	public Professor() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoEscolar() {
		return anoEscolar;
	}

	public void setAnoEscolar(String anoEscolar) {
		this.anoEscolar = anoEscolar;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getTelefoneDeContato() {
		return telefoneDeContato;
	}

	public void setTelefoneDeContato(String telefoneDeContato) {
		this.telefoneDeContato = telefoneDeContato;
	}

	public String getEmailDeContato() {
		return emailDeContato;
	}

	public void setEmailDeContato(String emailDeContato) {
		this.emailDeContato = emailDeContato;
	}




	
}	