package com.projetospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetospring.entities.Aluno;
import com.projetospring.exceptions.NegocioException;
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
	public Aluno findById(Long id) throws NegocioException { 
		Optional<Aluno> alunoOptional = repository.findById(id);
		
		if(! alunoOptional.isPresent()) {
			 throw new NegocioException("Aluno com id = " + id + " não econtrado no banco de dados.");
		}
		
		return alunoOptional.get();
	}
	
	/**
	 * Retorna o numero de alunos no banco com a
	 * matricula especificada
	 */
	public int findAlunoByMatricula(String matricula) {
		return repository.findAlunoByMatricula(matricula);
	}
	
	
	/**
	 * Método que persiste o aluno especificado e o retorna-o.
	 */
	public Aluno save(Aluno aluno) throws NegocioException{
		aluno.validar();
		validaAlunoNoBanco(aluno);
		return repository.save(aluno);
	}
	
	/**
	 * Método que deleta um aluno passando-o como parâmetro.
	 */
	public void delete(Aluno aluno) {
		aluno.validar();
		repository.delete(aluno);
	}
	
	/**
	 * Método que deleta um aluno pelo seu id.
	 */
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * Método privado que verifica se já existe um aluno
	 * com a mesma matrícula no banco de dados.
	 */
	private void validaAlunoNoBanco(Aluno aluno) throws NegocioException { 
		if(findAlunoByMatricula(aluno.getMatricula()) == 1 && aluno.getId() != 0) {
			throw new  NegocioException("Já existe um aluno com essa matrícula.");
		}
	}
	
	/////////////Getters and Setters///////////////////
	public AlunoRepository getRepository() {
		return repository;
	}

	public void setRepository(AlunoRepository repository) {
		this.repository = repository;
	}
	 
	
}
