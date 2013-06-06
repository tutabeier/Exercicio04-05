package br.com.livrariasofia.model;

public class LivroColecao extends Livro {

	private int volume;
	private int qtdLivros;

	public LivroColecao(String titulo, String descricao, String autor, 
			int volume, int qtdLivros, int id) {
		super(titulo, descricao, autor,id);
		this.volume = volume;
		if(qtdLivros >= 2){
			this.qtdLivros = qtdLivros;  
		}
		
		
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}


}
