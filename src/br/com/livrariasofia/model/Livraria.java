package br.com.livrariasofia.model;

import java.util.ArrayList;
import java.util.List;

public class Livraria {

	private ArrayList<Livro> listaLivro;
	
	public Livraria() {
		this.listaLivro = new ArrayList<Livro>();
		
		Livro livro = new Livro("As cronicas de nárnia","BlaBlaBla","Narnialandia",1);
		Livro livro2 = new Livro("Patinho feioa","Eles morrem no final","Brincadeira",2);
		Livro livro3 = new Livro("Branca de neve","Tem 7 anões","disney?",3);
		LivroColecao lc = new LivroColecao("A sociedade do anel", "tem hobbits", "jrrt", 1, 3,4);
		listaLivro.add(livro);
		listaLivro.add(livro2);
		listaLivro.add(livro3);
		listaLivro.add(lc);
		
	}

	public boolean add(Livro livro){
		return listaLivro.add(livro);
	}
	
	public ArrayList<Livro> getLivro() {
		return listaLivro;
	}
	
	public void removeByIndex(Livro livro){
		for(Livro l: listaLivro){
			if(l.getId() == livro.getId()){
				listaLivro.remove(livro);
			}
		}
	}
	
	
	
	public void alterarLivro(String titulo, String autor, String descricao, int id) {
		for(Livro l: listaLivro){	
			if(l.getId() == id){
				l.setAutor(autor);
				l.setDescricao(descricao);
				l.setTitulo(titulo);
			}
		}
	}
	
	
	
	
}
