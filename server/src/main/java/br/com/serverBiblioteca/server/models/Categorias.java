package br.com.serverBiblioteca.server.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table( name ="categorias")
public class Categorias implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idCategorias;
	
	private String descricaoCategoria;
	
	public Categorias() {}

	public Categorias(Integer idCategorias, String descricaoCategoria) {
		super();
		this.idCategorias = idCategorias;
		this.descricaoCategoria = descricaoCategoria;
	}

	//Getters and Setters
	public Integer getIdCategorias() {
		return idCategorias;
	}

	public void setIdCategorias(Integer idCategorias) {
		this.idCategorias = idCategorias;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}	
}
