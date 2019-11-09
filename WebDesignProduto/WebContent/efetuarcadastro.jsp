<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="br.com.designpatternprodutos.pojo.*" %>
   <%@ page import="br.com.designpatternprodutos.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Efetura Cadastro</title>
</head>
<body>
<%
String nome= request.getParameter("txtNome");

String autor = request.getParameter("txtAutor");

String genero = request.getParameter("txtGenero");

String ano = request.getParameter("txtAno");

String editora = request.getParameter("txtEditora");

String preco = request.getParameter("txtPreco");



//vamo efetuar o cadastro passando os dados
//para o pojo e depois para a camada dao

Livro li = new Livro();

li.setNome(nome);
li.setPreco(Double.parseDouble(preco));
li.setAutor(autor);
li.setGenero(genero);
li.setAno(Integer.parseInt(ano));
li.setEditora(editora);



DAOLivro daoLi = new DAOLivro();

if(daoLi.cadastro(li)){
	out.println("<h1>Cliente Cadastro com Sucesso!</h1>");
}
else{
	out.println("<h2>Não foi possivel cadastrar o cliente</h2>");
}
%>
</body>
</html>