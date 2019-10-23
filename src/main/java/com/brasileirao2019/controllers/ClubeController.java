package com.brasileirao2019.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brasileirao2019.models.Clube;
import com.brasileirao2019.repository.ClubeRepository;

@Controller
public class ClubeController {
	
	@Autowired
	private ClubeRepository cr;
	
	@RequestMapping("/clubeCadastro")
	public String clubeCadastro() {
		return "clube/clubeCadastro";
	}
	
	@RequestMapping(value="saveClube", method=RequestMethod.POST)
	public String saveClube(Clube clube) {
		cr.save(clube);
		return "clube/clubeCadastro";
	}
	
	
}
