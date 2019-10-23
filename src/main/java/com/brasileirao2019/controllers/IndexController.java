package com.brasileirao2019.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brasileirao2019.models.Clube;
import com.brasileirao2019.repository.ClubeRepository;
//import com.brasileirao2019.repository.ClubeRepository;

@Controller
public class IndexController {
	
	@Autowired
	private ClubeRepository cr;
	
	@Autowired
	private EntityManager em;
		
	
	
	
	
	
	
	
	
	public void buscarPosicao(Collection<Clube> clubes){
		int index = 1;
		for (Clube clube : clubes) {
			cr.updateClubePosicao(index++, clube.getId());
		}
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
		String jpql = "select c from Clube c order by c.pontos desc";
		TypedQuery<Clube> tq = em.createQuery(jpql, Clube.class);
		Collection<Clube> clubes = tq.getResultList();
				
		buscarPosicao(clubes);

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("clubes", clubes);
		
		return mv;
	}
	
	//
	//
	//
	//
}

