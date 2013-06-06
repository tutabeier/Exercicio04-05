package br.com.livrariasofia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariasofia.model.Livraria;
import br.com.livrariasofia.model.Livro;
import br.com.livrariasofia.model.LivroColecao;

public class LivroController extends HttpServlet {
	private ArrayList<Livro> listaLivro;

	private static final long serialVersionUID = -4924269687314937814L;

	public LivroController() {
		super();
		Livraria livraria = new Livraria();
		this.listaLivro = livraria.getLivro();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);

		String descricao = request.getParameter("descricao");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		String id = request.getParameter("id");
		String volume;
		String qtdLivros;
		qtdLivros = request.getParameter("qtdLivros");
		volume = request.getParameter("volume");

		Livraria livraria = new Livraria();

		if (request.getParameter("volume").equals("")) {
			Livro livro = new Livro(descricao, autor, titulo,
					Integer.parseInt(id));
			livraria.add(livro);

		} else {
			LivroColecao livroColecao = new LivroColecao(titulo, descricao,
					autor, Integer.parseInt(volume),
					Integer.parseInt(qtdLivros), Integer.parseInt(id));
			livraria.add(livroColecao);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/cadastro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String descricao = request.getParameter("descricao");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");

		Livraria livraria = new Livraria();
		Livro livro = new Livro(titulo, descricao, autor, id);

		if (action.equals("editar")) {
			Livro livroParam = new Livro(titulo, descricao, autor, id);

		} else if (action.equals("apagar")) {
			livraria.removeByIndex(livro);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/livroExcluido.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * Funciona
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action == null) {
			
			// Cria um array de livros
			ArrayList<Livro> listaLivro = new ArrayList<Livro>();
			// Popula o array com os livros do model
			listaLivro = this.retornarLivros();

			RequestDispatcher rd = request.getRequestDispatcher("/listaLivros.jsp");
			// Seta o atributo arrayDeLivros com o array listaLivro
			request.setAttribute("arrayDeLivros", listaLivro);
			rd.forward(request, response);			

		} else {
				
			this.doGet(request, response);

		}
	}

	public ArrayList<Livro> retornarLivros() {
		return this.listaLivro;
	}

}
