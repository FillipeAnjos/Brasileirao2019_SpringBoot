package com.brasileirao2019.controllers;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	EntityManager em;
	
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
	
	//Metodo abaixo referente a posição na tabela!
	public void buscarPosicao(){
		String jpql = "select t from Tabela t order by t.pontos desc";
		TypedQuery<Tabela> tq = em.createQuery(jpql, Tabela.class);
		Collection<Tabela> tabelas = tq.getResultList();
		
		int index = 1;
		for (Tabela tabela : tabelas) {
			tr.updateTabelaPosicao(index++, tabela.getId());
		}
	}
	
	//Metodo abaixo serve para o cadastro dos jogos!
	@RequestMapping(value="/cadastrarJogo", method=RequestMethod.POST)
	public String cadastrar(Jogos jogos) {
		
		Tabela tabelaMandante = new Tabela();
		Tabela tabelaVisitante = new Tabela();
		
			String joinClubeTabela = "select c, t from Clube c join c.tabela t where c.id = :id";
			
			TypedQuery<Object[]> resJoinClubeTabelaMandante = em.createQuery(joinClubeTabela, Object[].class)
					.setParameter("id", Long.valueOf(jogos.getIdMandante()));
			TypedQuery<Object[]> resJoinClubeTabelaVisitante = em.createQuery(joinClubeTabela, Object[].class)
					.setParameter("id", Long.valueOf(jogos.getIdVisitante()));
			
			Object[] ctMandante = resJoinClubeTabelaMandante.getSingleResult();
			Object[] ctVisitante = resJoinClubeTabelaVisitante.getSingleResult();
				
	//If abaixo é referente ao Mandante vitorioso
		if(jogos.getMandanteGols() > jogos.getVisitanteGols()) {
			/* 
				******************************* Mandante *******************************
			*/
			tabelaMandante.setId(((Clube) ctMandante[0]).getTabela().getId());//5 Vasco
			
			tabelaMandante.setPosicao(((Tabela) ctMandante[1]).getPosicao());
			tabelaMandante.setNomeClube(((Tabela) ctMandante[1]).getNomeClube());
			tabelaMandante.setPontos(((Tabela) ctMandante[1]).getPontos() + 3);
			tabelaMandante.setJogos(((Tabela) ctMandante[1]).getJogos() + 1);
			tabelaMandante.setVitorias(((Tabela) ctMandante[1]).getVitorias() + 1);
			tabelaMandante.setEmpates(((Tabela) ctMandante[1]).getEmpates());
			tabelaMandante.setDerrotas(((Tabela) ctMandante[1]).getDerrotas());
			tabelaMandante.setGolsPro(((Tabela) ctMandante[1]).getGolsPro() + jogos.getMandanteGols());
			tabelaMandante.setGolsContra(((Tabela) ctMandante[1]).getGolsContra() + jogos.getVisitanteGols());
			tabelaMandante.setSaldoGol(((Tabela) ctMandante[1]).getSaldoGol() + jogos.getMandanteGols() - jogos.getVisitanteGols());
			tabelaMandante.setPorcentagem(0.0);
			tabelaMandante.setClube(cr.findById(jogos.getIdMandante()));// 1
			
			/* 
			 	******************************* Visitante *******************************
			*/
			tabelaVisitante.setId(((Clube) ctVisitante[0]).getTabela().getId());//7 Botafogo
			
			tabelaVisitante.setPosicao(((Tabela) ctVisitante[1]).getPosicao());
			tabelaVisitante.setNomeClube(((Tabela) ctVisitante[1]).getNomeClube());
			tabelaVisitante.setPontos(((Tabela) ctVisitante[1]).getPontos());
			tabelaVisitante.setJogos(((Tabela) ctVisitante[1]).getJogos() + 1);
			tabelaVisitante.setVitorias(((Tabela) ctVisitante[1]).getVitorias());
			tabelaVisitante.setEmpates(((Tabela) ctVisitante[1]).getEmpates());
			tabelaVisitante.setDerrotas(((Tabela) ctVisitante[1]).getDerrotas() + 1);
			tabelaVisitante.setGolsPro(((Tabela) ctVisitante[1]).getGolsPro() + jogos.getVisitanteGols());
			tabelaVisitante.setGolsContra(((Tabela) ctVisitante[1]).getGolsContra() + jogos.getMandanteGols());
			tabelaVisitante.setSaldoGol(((Tabela) ctVisitante[1]).getSaldoGol() + jogos.getVisitanteGols() - jogos.getMandanteGols());
			tabelaVisitante.setPorcentagem(0.0);
			tabelaVisitante.setClube(cr.findById(jogos.getIdVisitante()));// 1
		
	//If abaixo é referente ao Visitante vitorioso
		}else if(jogos.getMandanteGols() < jogos.getVisitanteGols()) {
			/* 
			 	******************************* Visitante *******************************
			*/
			tabelaVisitante.setId(((Clube) ctVisitante[0]).getTabela().getId());//7 Botafogo
			
			tabelaVisitante.setPosicao(((Tabela) ctVisitante[1]).getPosicao());
			tabelaVisitante.setNomeClube(((Tabela) ctVisitante[1]).getNomeClube());
			tabelaVisitante.setPontos(((Tabela) ctVisitante[1]).getPontos() + 3);
			tabelaVisitante.setJogos(((Tabela) ctVisitante[1]).getJogos() + 1);
			tabelaVisitante.setVitorias(((Tabela) ctVisitante[1]).getVitorias() + 1);
			tabelaVisitante.setEmpates(((Tabela) ctVisitante[1]).getEmpates());
			tabelaVisitante.setDerrotas(((Tabela) ctVisitante[1]).getDerrotas());
			tabelaVisitante.setGolsPro(((Tabela) ctVisitante[1]).getGolsPro() + jogos.getVisitanteGols());
			tabelaVisitante.setGolsContra(((Tabela) ctVisitante[1]).getGolsContra() + jogos.getMandanteGols());
			tabelaVisitante.setSaldoGol(((Tabela) ctVisitante[1]).getSaldoGol() + jogos.getVisitanteGols() - jogos.getMandanteGols());
			tabelaVisitante.setPorcentagem(0.0);
			tabelaVisitante.setClube(cr.findById(jogos.getIdVisitante()));// 1	
		
			/* 
				******************************* Mandante *******************************
			*/
			tabelaMandante.setId(((Clube) ctMandante[0]).getTabela().getId());//5 Vasco
			
			tabelaMandante.setPosicao(((Tabela) ctMandante[1]).getPosicao());
			tabelaMandante.setNomeClube(((Tabela) ctMandante[1]).getNomeClube());
			tabelaMandante.setPontos(((Tabela) ctMandante[1]).getPontos());
			tabelaMandante.setJogos(((Tabela) ctMandante[1]).getJogos() + 1);
			tabelaMandante.setVitorias(((Tabela) ctMandante[1]).getVitorias());
			tabelaMandante.setEmpates(((Tabela) ctMandante[1]).getEmpates());
			tabelaMandante.setDerrotas(((Tabela) ctMandante[1]).getDerrotas() + 1);
			tabelaMandante.setGolsPro(((Tabela) ctMandante[1]).getGolsPro() + jogos.getMandanteGols());
			tabelaMandante.setGolsContra(((Tabela) ctMandante[1]).getGolsContra() + jogos.getVisitanteGols());
			tabelaMandante.setSaldoGol(((Tabela) ctMandante[1]).getSaldoGol() + jogos.getMandanteGols() - jogos.getVisitanteGols());
			tabelaMandante.setPorcentagem(0.0);
			tabelaMandante.setClube(cr.findById(jogos.getIdMandante()));// 1
			
	//If abaixo é referente ao Empate
		}else {
			/* 
				******************************* Mandante *******************************
			*/
			tabelaMandante.setId(((Clube) ctMandante[0]).getTabela().getId());//5 Vasco
			
			tabelaMandante.setPosicao(((Tabela) ctMandante[1]).getPosicao());
			tabelaMandante.setNomeClube(((Tabela) ctMandante[1]).getNomeClube());
			tabelaMandante.setPontos(((Tabela) ctMandante[1]).getPontos() + 1);
			tabelaMandante.setJogos(((Tabela) ctMandante[1]).getJogos() + 1);
			tabelaMandante.setVitorias(((Tabela) ctMandante[1]).getVitorias());
			tabelaMandante.setEmpates(((Tabela) ctMandante[1]).getEmpates() + 1);
			tabelaMandante.setDerrotas(((Tabela) ctMandante[1]).getDerrotas());
			tabelaMandante.setGolsPro(((Tabela) ctMandante[1]).getGolsPro() + jogos.getMandanteGols());
			tabelaMandante.setGolsContra(((Tabela) ctMandante[1]).getGolsContra() + jogos.getVisitanteGols());
			tabelaMandante.setSaldoGol(((Tabela) ctMandante[1]).getSaldoGol() + jogos.getMandanteGols() - jogos.getVisitanteGols());
			tabelaMandante.setPorcentagem(0.0);
			tabelaMandante.setClube(cr.findById(jogos.getIdMandante()));// 1
			
			/* 
			 	******************************* Visitante *******************************
			*/
			tabelaVisitante.setId(((Clube) ctVisitante[0]).getTabela().getId());//7 Botafogo
			
			tabelaVisitante.setPosicao(((Tabela) ctVisitante[1]).getPosicao());
			tabelaVisitante.setNomeClube(((Tabela) ctVisitante[1]).getNomeClube());
			tabelaVisitante.setPontos(((Tabela) ctVisitante[1]).getPontos() + 1);
			tabelaVisitante.setJogos(((Tabela) ctVisitante[1]).getJogos() + 1);
			tabelaVisitante.setVitorias(((Tabela) ctVisitante[1]).getVitorias());
			tabelaVisitante.setEmpates(((Tabela) ctVisitante[1]).getEmpates() + 1);
			tabelaVisitante.setDerrotas(((Tabela) ctVisitante[1]).getDerrotas());
			tabelaVisitante.setGolsPro(((Tabela) ctVisitante[1]).getGolsPro() + jogos.getVisitanteGols());
			tabelaVisitante.setGolsContra(((Tabela) ctVisitante[1]).getGolsContra() + jogos.getMandanteGols());
			tabelaVisitante.setSaldoGol(((Tabela) ctVisitante[1]).getSaldoGol() + jogos.getVisitanteGols() - jogos.getMandanteGols());
			tabelaVisitante.setPorcentagem(0.0);
			tabelaVisitante.setClube(cr.findById(jogos.getIdVisitante()));// 1
		}
		
		tr.save(tabelaMandante);
		tr.save(tabelaVisitante);
		jr.save(jogos);
		buscarPosicao();

		return "redirect:/jogo";
	}
	
}
