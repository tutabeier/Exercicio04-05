package br.com.livrariasofia.model;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class Livro {

	private String titulo;
	private String descricao;
	private String autor;
	private int id;
	
	public Livro(String titulo, String descricao, String autor, int id) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
