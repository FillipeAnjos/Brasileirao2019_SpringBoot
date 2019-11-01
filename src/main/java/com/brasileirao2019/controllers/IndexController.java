package com.brasileirao2019.controllers;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brasileirao2019.models.Tabela;
import com.brasileirao2019.repository.TabelaRepository;
//import com.brasileirao2019.repository.ClubeRepository;

@Controller
public class IndexController {
	
	@Autowired
	private EntityManager em;
		
	

	
	@RequestMapping("/")
	public ModelAndView index() {
		String jpql = "select t from Tabela t order by t.pontos desc";
		TypedQuery<Tabela> tq = em.createQuery(jpql, Tabela.class);
		Collection<Tabela> tabelas = tq.getResultList();
				
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("tabelas", tabelas);
		
		return mv;
	}
	
	//
	//
	//
	//
}

