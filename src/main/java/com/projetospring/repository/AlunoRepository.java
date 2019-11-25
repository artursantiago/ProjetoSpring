package com.projetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetospring.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	@Query //pesquisar sobre o count e fazer o comando sql
	public void findAlunoByMatricula();
}
