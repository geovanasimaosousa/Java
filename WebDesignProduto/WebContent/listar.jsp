<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="br.com.designpatternprodutos.pojo.*" %>
 <%@ page import="br.com.designpatternprodutos.dao.*" %>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar os Livros</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
</head>

<body>

<header>
<h1>Livro Cadastrado</h1>
</header>

<main>
<table>
	<tr>
		<th>Nome</th>
		<th>Autor</th>
		<th>Genero</th>
		<th>Ano</th>
		<th>Editora</th>
		<th>Preco</th>
	</tr>
	
<%
DAOLivro daoli= new DAOLivro();
List<Livro> lst =new ArrayList<Livro>();
lst = daoli.buscar();

for(int i=0 ; i < lst.size(); i++){
	out.println("<tr>");
	out.println("<td>"+lst.get(i).getNome()+"</td>");
	out.println("<td>"+lst.get(i).getAutor()+"</td>");
	out.println("<td>"+lst.get(i).getGenero()+"</td>");
	out.println("<td>"+lst.get(i).getAno()+"</td>");
	out.println("<td>"+lst.get(i).getEditora()+"</td>");
	out.println("<td>"+lst.get(i).getPreco()+"</td>");
	out.println("</tr>");
}
%>
</table>
</main>


<footer>

</footer>
</body>
</html>