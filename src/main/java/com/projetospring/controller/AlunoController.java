package com.projetospring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.entities.Aluno;
import com.projetospring.service.AlunoService;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	/**
	 * 
	 */
	@GetMapping()
	public List<Aluno> findAll() {
		return service.findAll();
	}
	
	/*
	
	@GetMapping()
	public Aluno findAlunoByMatricula() { 
		return service.getAlunoByMatricula();
		
		Função para achar o aluno quando clicar no botão de editar
		Provavelmete esse aluno será armazenado no localStorage em json
		
	}
	
	*/
	
	/*
	  
	@PutMapping()
	
		função para salvar um aluno que está sendo atualizado
		
	*/
	
	/*
	 @DeleteMapping()
	 
	 	função para deletar um aluno quando clicado no botão de deletar
	 */
	
	/*
	 Função para chamar a pagina de cadastro
	 */
	
	/*
	 função para chamar a página de listagem
	 */
}









