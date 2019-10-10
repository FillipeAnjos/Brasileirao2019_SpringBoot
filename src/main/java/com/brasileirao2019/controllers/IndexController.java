package com.brasileirao2019.controllers;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brasileirao2019.models.Clube;
//import com.brasileirao2019.repository.ClubeRepository;

@Controller
public class IndexController {
	
	//@Autowired
	//private ClubeRepository cr;
	
	@Autowired
	private EntityManager em;
	
	//TESTEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	//show
	//TESTEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	//show
	//TESTEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	//show
	
	@RequestMapping("/")
	public ModelAndView index() {
		String jpql = "select c from Clube c order by c.pontos desc";
		TypedQuery<Clube> tq = em.createQuery(jpql, Clube.class);
		Collection<Clube> clubes = tq.getResultList();
		/*
		Collection<Clube> clubes = cr.findAll();
		*/
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("clubes", clubes);
		
		return mv;
	}
}
