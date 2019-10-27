package com.brasileirao2019.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.brasileirao2019.models.Clube;
import com.brasileirao2019.models.Jogos;
import com.brasileirao2019.models.Tabela;
import com.brasileirao2019.repository.ClubeRepository;
import com.brasileirao2019.repository.JogosRepository;
import com.brasileirao2019.repository.TabelaRepository;

@Controller
public class JogosController {
	
	//private Tabela tabela; 
	
	@Autowired
	private TabelaRepository tr;
	
	@Autowired
	private ClubeRepository cr;
	
	@Autowired
	private JogosRepository jr;
	
	@RequestMapping(value="/jogo", method = RequestMethod.GET)
	public ModelAndView jogos() {
		Collection<Clube> clubes = cr.burcarClube();
		ModelAndView mv = new ModelAndView("jogos/jogo");
		mv.addObject("clubes", clubes);
		return mv;
	}
	
	@RequestMapping(value="/cadastrarJogo", method=RequestMethod.POST)
	public String cadastrar(Jogos jogos) {	

		//jr.save(jogos);
		
		/* 
		  Falta terminar a logica
		*/
				Clube clube = cr.findById(5);
		
				Tabela tabela = new Tabela();
				
				tabela.setId(5);
				tabela.setPontos(3);
				tabela.setDerrotas(1);
				tabela.setEmpates(1);
				tabela.setGolsContra(1);
				tabela.setGolsPro(1);
				tabela.setJogos(1);
				tabela.setNomeClube("Vasco");
				tabela.setPorcentagem(1.0);
				tabela.setPosicao(1);
				tabela.setSaldoGol(1);
				tabela.setVitorias(1);
				tabela.setClube(clube);
				tr.save(tabela);
		

		return "redirect:/jogo";
	}
	
}
