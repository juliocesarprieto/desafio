package br.com.serverBiblioteca.server.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name ="livros")
public class Livros implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idLivros;
	private String tituloLivro;
	private String descricaoLivro;
	private Integer ano;
	private Integer totalPaginas;
	private String autor;
	
	public Livros() {}
	
	public Livros(Integer idLivros, String tituloLivro, String descricaoLivro, Integer ano, Integer totalPaginas, String autor) {
		super();
		this.idLivros = idLivros;
		this.tituloLivro = tituloLivro;
		this.descricaoLivro = descricaoLivro;
		this.ano = ano;
		this.totalPaginas = totalPaginas;
		this.autor = autor;
	}
	
	// Getters and Setters
	public Integer getIdLivros() {
		return idLivros;
	}
	public void setIdLivros(Integer idLivros) {
		this.idLivros = idLivros;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public String getDescricaoLivro() {
		return descricaoLivro;
	}
	public void setDescricaoLivro(String descricaoLivro) {
		this.descricaoLivro = descricaoLivro;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
