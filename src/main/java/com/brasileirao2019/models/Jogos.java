package com.brasileirao2019.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jogos implements Serializable{

	private static final long serialVersionUID = 5296104661885980789L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String turno;
	private Integer rodada;
	private Integer idMandante;
	private Integer mandanteGols;
	private Integer idVisitante;
	private Integer visitanteGols;
	private String campoMandante;
	private Integer vencedor;
	
	@OneToOne
	private Clube clube;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public Integer getRodada() {
		return rodada;
	}
	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}
	public Integer getIdMandante() {
		return idMandante;
	}
	public void setIdMandante(Integer idMandante) {
		this.idMandante = idMandante;
	}
	public Integer getMandanteGols() {
		return mandanteGols;
	}
	public void setMandanteGols(Integer mandanteGols) {
		this.mandanteGols = mandanteGols;
	}
	public Integer getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(Integer idVisitante) {
		this.idVisitante = idVisitante;
	}
	public Integer getVisitanteGols() {
		return visitanteGols;
	}
	public void setVisitanteGols(Integer visitanteGols) {
		this.visitanteGols = visitanteGols;
	}
	public String getCampoMandante() {
		return campoMandante;
	}
	public void setCampoMandante(String campoMandante) {
		this.campoMandante = campoMandante;
	}
	public Integer getVencedor() {
		return vencedor;
	}
	public void setVencedor(Integer vencedor) {
		this.vencedor = vencedor;
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	
	
	

}
