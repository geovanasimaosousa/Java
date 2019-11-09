<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="br.com.designpattern.pojo.*" %>
 <%@ page import="br.com.designpattern.dao.*" %>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar os clientes</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
</head>

<body>

<header>
<h1>Cliente Cadastrado</h1>
</header>

<main>
<table>
	<tr>
		<th>Id do Cliente</th>
		<th>Nome</th>
		<th>RG</th>
		<th>CPF</th>
	</tr>
	
<%
DAOCliente daoCli= new DAOCliente();
List<Cliente> lst =new ArrayList<Cliente>();
lst = daoCli.buscar();

for(int i=0 ; i < lst.size(); i++){
	out.println("<tr>");
	out.println("<td>"+lst.get(i).getId()+"</td>");
	out.println("<td>"+lst.get(i).getNome()+"</td>");
	out.println("<td>"+lst.get(i).getRG()+"</td>");
	out.println("<td>"+lst.get(i).getCpf()+"</td>");
	out.println("</tr>");
}
%>
</table>
</main>


<footer>

</footer>
</body>
</html>