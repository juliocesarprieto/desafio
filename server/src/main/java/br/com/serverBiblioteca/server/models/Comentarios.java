package br.com.serverBiblioteca.server.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table( name = "comentarios")
public class Comentarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idComentario;
	
	private String descricaoComentario;
	
	//relacionamento
	private Integer libroFk;
	private Integer usuarioFk;
	
	public Comentarios() {}
	
	public Comentarios(Integer idComentario, String descricaoComentario, Integer libroFk, Integer usuarioFk) {
		super();
		this.idComentario = idComentario;
		this.descricaoComentario = descricaoComentario;
		this.libroFk = libroFk;
		this.usuarioFk = usuarioFk;
	}

	//Getters and Setters
	public Integer getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescricaoComentario() {
		return descricaoComentario;
	}

	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}	
}
