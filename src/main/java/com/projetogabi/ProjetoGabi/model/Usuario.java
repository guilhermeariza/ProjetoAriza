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
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String usuario;
	
	@NotNull
	@Size(min = 8, max = 15)
	private String senha;
	
	@OneToOne(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Professor pessoaJuridica;
	
	public Usuario() {

	}
	public Long getId_usuario() {
		return id;
	}

	public void setId_usuario(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Professor getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(Professor pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
}
	