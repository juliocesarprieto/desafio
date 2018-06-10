package br.com.serverBiblioteca.server.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name ="libros")
public class Libros implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idLibros;
	private String tituloLibro;
	private String descricaoLibro;
	private Integer ano;
	private Integer totalPaginas;
	
	public Libros() {}
	
	public Libros(Integer idLibros, String tituloLibro, String descricaoLibro, Integer ano, Integer totalPaginas) {
		super();
		this.idLibros = idLibros;
		this.tituloLibro = tituloLibro;
		this.descricaoLibro = descricaoLibro;
		this.ano = ano;
		this.totalPaginas = totalPaginas;
	}
	
	// Getters and Setters
	public Integer getIdLibros() {
		return idLibros;
	}
	public void setIdLibros(Integer idLibros) {
		this.idLibros = idLibros;
	}
	public String getTituloLibro() {
		return tituloLibro;
	}
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	public String getDescricaoLibro() {
		return descricaoLibro;
	}
	public void setDescricaoLibro(String descricaoLibro) {
		this.descricaoLibro = descricaoLibro;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	
	

}
