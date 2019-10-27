package com.brasileirao2019.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brasileirao2019.models.Tabela;
import com.brasileirao2019.repository.TabelaRepository;

@Controller
public class TabelaController {
	
	@Autowired
	private TabelaRepository tr;
	
	@RequestMapping("/clubeCadastro")
	public String clubeCadastro() {
		return "clube/clubeCadastro";
	}
	
	@RequestMapping(value="saveClube", method=RequestMethod.POST)
	public String saveClube(Tabela tabela) {
		tr.save(tabela);
		return "clube/clubeCadastro";
	}

}
