package com.projetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetospring.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	/**
	 * Retorna o número de alunos que existem no banco
	 * com a matricula igual a matricula especificada.
	 */
	@Query("select count(matricula) from com.projetospring.entities.Aluno a where a.matricula = ?1;")
	public int findAlunoByMatricula(String matricula);
}
