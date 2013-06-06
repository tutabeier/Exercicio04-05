package br.com.livrariasofia.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariasofia.model.Livraria;
import br.com.livrariasofia.model.Livro;
import br.com.livrariasofia.model.LivroColecao;

/**
 * Servlet implementation class LivSofiaController
 */
public class LivSofiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LivSofiaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String descricao = request.getParameter("descricao");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		String volume;
		String qtdLivros;
		qtdLivros = request.getParameter("qtdLivros"); 
		volume = request.getParameter("volume");
		int id = Integer.parseInt(request.getParameter("id"));

    	Livraria livraria = new Livraria();
    	Livro livroParam = new Livro(titulo, descricao, autor, id);
    	
    	if(request.getParameter("volume").equals("")) {
    		Livro livro = new Livro(descricao,autor,titulo, id);
    		livraria.removeByIndex(livro);
    		
    	} else {
    		LivroColecao livroColecao = new LivroColecao(titulo, descricao, autor, Integer.parseInt(volume), Integer.parseInt(qtdLivros),id);
    		livraria.add(livroColecao);
    	}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro.jsp");
        dispatcher.forward(request, response);
    
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
		
		
		
	}
	
	
	
	

}
