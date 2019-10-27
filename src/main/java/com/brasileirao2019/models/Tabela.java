package com.brasileirao2019.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Tabela implements Serializable{
	
	private static final long serialVersionUID = -1707458663770863355L;
	
	//P	J	V	E	D	GP	GC	SG	%	ÚLT. JOGOS

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@NotEmpty
		private String nomeClube;	
		private Integer pontos;
		private Integer jogos;
		private Integer vitorias;
		private Integer empates;
		private Integer derrotas;
		private Integer golsPro;
		private Integer golsContra;
		private Integer saldoGol;
		private Double porcentagem;
		private Integer posicao;
		
		@OneToOne
		private Clube clube;
		
		
		
		
		
		
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Integer getPosicao() {
			return posicao;
		}
		public void setPosicao(Integer posicao) {
			this.posicao = posicao;
		}
		public String getNomeClube() {
			return nomeClube;
		}
		public void setNomeClube(String nomeClube) {
			this.nomeClube = nomeClube;
		}
		public Integer getPontos() {
			return pontos;
		}
		public void setPontos(Integer pontos) {
			this.pontos = pontos;
		}
		public Integer getJogos() {
			return jogos;
		}
		public void setJogos(Integer jogos) {
			this.jogos = jogos;
		}
		public Integer getVitorias() {
			return vitorias;
		}
		public void setVitorias(Integer vitorias) {
			this.vitorias = vitorias;
		}
		public Integer getEmpates() {
			return empates;
		}
		public void setEmpates(Integer empates) {
			this.empates = empates;
		}
		public Integer getDerrotas() {
			return derrotas;
		}
		public void setDerrotas(Integer derrotas) {
			this.derrotas = derrotas;
		}
		public Integer getGolsPro() {
			return golsPro;
		}
		public void setGolsPro(Integer golsPro) {
			this.golsPro = golsPro;
		}
		public Integer getGolsContra() {
			return golsContra;
		}
		public void setGolsContra(Integer golsContra) {
			this.golsContra = golsContra;
		}
		public Integer getSaldoGol() {
			return saldoGol;
		}
		public void setSaldoGol(Integer saldoGol) {
			this.saldoGol = saldoGol;
		}
		public Double getPorcentagem() {
			return porcentagem;
		}
		public void setPorcentagem(Double porcentagem) {
			this.porcentagem = porcentagem;
		}
		public Clube getClube() {
			return clube;
		}
		public void setClube(Clube clube) {
			this.clube = clube;
		}

}
