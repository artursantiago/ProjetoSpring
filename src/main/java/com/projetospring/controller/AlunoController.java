package com.projetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.entities.Aluno;
import com.projetospring.exceptions.NegocioException;
import com.projetospring.service.AlunoService;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	/**
	 * Método que retorna a lista de todos os alunos do banco de dados
	 */
	@GetMapping("/listagem")
	public List<Aluno> findAll() {
		return service.findAll();
	}
	
	/**
	 * Método que salva um novo aluno no banco de dados
	 */
	@PostMapping("/formulario")
	public Aluno save(@RequestBody Aluno aluno) {
		try {
			service.save(aluno);
		} catch (NegocioException e) {
			//mostra mensgem de erro
		}
		return aluno; 
	}
	
	/**
	 * Método que atualiza os dados do aluno no banco de dados.
	 */
	@PutMapping("/formulario")
	public Aluno update(@RequestBody Aluno aluno) {
		try {
			service.save(aluno);
		} catch (NegocioException e) {
			//mostra mensgem de erro
		}
		return aluno; 
	}
	
	/**
	 * Método que deleta um aluno com o id especificado.
	 */
	@DeleteMapping("/listagem/{id}")
	public void delete(@PathVariable("id") Long id) { 
		service.deleteById(id);
	}
	 
	@GetMapping("/listagem/{id}")
	public Aluno findAlunoById(@PathVariable("id") Long id) {
		try {
			return service.findById(id);
		} catch (NegocioException e) {
			// mostra mensagem de erro
			return null;
		}
	}
	
	/**
	 Função para chamar a pagina de cadastro
	 */
	
	
	/**
	 função para chamar a página de listagem 
	 */
}









