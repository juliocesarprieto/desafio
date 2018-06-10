package br.com.serverBiblioteca.server.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table( name = "editales")
public class Editales implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idEdital;
	private String nomeEdital;
	
	public Editales() {}	

	public Editales(Integer idEdital, String nomeEdital) {
		super();
		this.idEdital = idEdital;
		this.nomeEdital = nomeEdital;
	}
	
	//Getters and Setters
	public Integer getIdEdital() {
		return idEdital;
	}

	public void setIdEdital(Integer idEdital) {
		this.idEdital = idEdital;
	}

	public String getNomeEdital() {
		return nomeEdital;
	}

	public void setNomeEdital(String nomeEdital) {
		this.nomeEdital = nomeEdital;
	}	
	
	
	
}
