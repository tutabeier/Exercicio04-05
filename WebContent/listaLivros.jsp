<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.com.livrariasofia.model.*, br.com.livrariasofia.controller.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Teste" method="get">

<%
	ArrayList<Livro> listaLivro = (ArrayList<Livro>) request.getAttribute("arrayDeLivros");
%>

<h1>Livros</h1>
<fieldset>
<legend>Livro 1</legend>
<p>${param.titulo} ${param.descricao} ${param.autor} ${param.volume} ${param.qtdLivros}</p> 

<a href=""></a>
<a href=""></a>
</fieldset>

<%
int i = 2;
for(Livro liv: listaLivro) {	
%>
<fieldset>
<legend>Livro <%= i %></legend>

<p name="autor">Autor: <%= liv.getAutor()%></p>
<p name="descricao">Descrição: <%= liv.getDescricao()%></p>
<p name="titulo"> Título: <%= liv.getTitulo()%>"</p>
<p name="id"> ID: <%= liv.getId()%></p>

<a href="livroController?autor=<%= liv.getAutor()%>&descricao=<%= liv.getDescricao()%>&titulo=<%= liv.getTitulo()%>&id=<%= liv.getId()%>&action=editar" name="editar">Editar</a>
<a href="livroController?autor=<%= liv.getAutor()%>&descricao=<%= liv.getDescricao()%>&titulo=<%= liv.getTitulo()%>&id=<%= liv.getId()%>&action=apagar" name="apagar">Apagar</a>
</fieldset>
<%
i++;
} 
%>


</form>

</body>
</html>