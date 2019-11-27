package com.projetospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetospring.entities.Aluno;
import com.projetospring.repository.AlunoRepository;

public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	/**
	 * Metodo que busca todos os dados da tabela
	 */
	public List<Aluno> findAll(){ 
		return repository.findAll();
	}
	
	/**
	 * Método que retorna o Aluno com o Id especificado
	 */
	public Aluno findById(Long id) { 
		Optional<Aluno> alunoOptional = repository.findById(id);
		
		if(! alunoOptional.isPresent()) {
			 //throw new AlunoNotFoundException("Aluno com id = " + id + " não econtrado.");
		}
		
		return alunoOptional.get();
	}
	
	/**
	 * Retorna o numero de alunos no banco com a
	 * matricula especificada
	 */
	public Long findAlunoByMatricula(String matricula) {
		return repository.findAlunoByMatricula(matricula);
	}
	
	
	/**
	 * Método que persiste o aluno especificado e o retorna-o.
	 */
	public Aluno save(Aluno aluno) {
		return repository.save(aluno);
	}
	
	/**
	 * Método que deleta um aluno passando-o como parâmetro.
	 */
	public void delete(Aluno aluno) { 
		repository.delete(aluno);
	}
	
	/**
	 * Método que deleta um aluno pelo seu id.
	 */
	public void deleteById(Long id) { 
		repository.deleteById(id);
	}
	
	
	/////////////Getters and Setters///////////////////
	public AlunoRepository getRepository() {
		return repository;
	}

	public void setRepository(AlunoRepository repository) {
		this.repository = repository;
	}
	
	
}
