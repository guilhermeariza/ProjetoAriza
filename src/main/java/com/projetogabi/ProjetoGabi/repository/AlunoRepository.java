package com.projetogabi.ProjetoGabi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetogabi.ProjetoGabi.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{


}