package com.brasileirao2019.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Clube implements Serializable{

	private static final long serialVersionUID = 1L;

	//P	J	V	E	D	GP	GC	SG	%	ÚLT. JOGOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String nomeClube;	
	@NotEmpty
	private String pontos;
	@NotEmpty
	private String jogos;
	@NotEmpty
	private String vitorias;
	@NotEmpty
	private String empates;
	@NotEmpty
	private String derrotas;
	@NotEmpty
	private String golsPro;
	@NotEmpty
	private String golsContra;
	@NotEmpty
	private String saldoGol;
	@NotEmpty
	private String porcentagem;
	
	
	
	
	
	
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeClube() {
		return nomeClube;
	}
	public void setNomeClube(String nomeClube) {
		this.nomeClube = nomeClube;
	}
	public String getPontos() {
		return pontos;
	}
	public void setPontos(String pontos) {
		this.pontos = pontos;
	}
	public String getJogos() {
		return jogos;
	}
	public void setJogos(String jogos) {
		this.jogos = jogos;
	}
	public String getVitorias() {
		return vitorias;
	}
	public void setVitorias(String vitorias) {
		this.vitorias = vitorias;
	}
	public String getEmpates() {
		return empates;
	}
	public void setEmpates(String empates) {
		this.empates = empates;
	}
	public String getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(String derrotas) {
		this.derrotas = derrotas;
	}
	public String getGolsPro() {
		return golsPro;
	}
	public void setGolsPro(String golsPro) {
		this.golsPro = golsPro;
	}
	public String getGolsContra() {
		return golsContra;
	}
	public void setGolsContra(String golsContra) {
		this.golsContra = golsContra;
	}
	public String getSaldoGol() {
		return saldoGol;
	}
	public void setSaldoGol(String saldoGol) {
		this.saldoGol = saldoGol;
	}
	public String getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(String porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	
	
	
	
	
	
	
	
	
}
