<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
</head>
<body>
 	<header>
 	<h1>Formulário de cadastro</h1>
 	<a href="index.jsp">Voltar</a>
 	</header>
 	
 	
 	<main>
 	<form action="efetuarcadastro.jsp" method="post">
 	<input type="text" name="txtNome" id="txtNome" placeholder="Nome do Cliente">
 	
 	<input type="text" name="txtAutor" id="txtAutor" placeholder="Autor do Livro">
 	
 	<input type="text" name="txtGenero" id="txtGenero" placeholder="Genero do Livro">
 	
 	<input type="text" name="txtAno" id="txtAno" placeholder="Ano do Livro">
 	
 	<input type="text" name="txtEditora" id="txtEditora" placeholder="Editora do Livro">
 	
 	<input type="text" name="txtPreco" id="txtPreco" placeholder="Preço do Livro">
 	
 	

 	<input type="submit" value="Cadastrar">
 	</form>
 	</main>
 	
 	 	
 	<footer>
 	Copyright - Todos os direitos reservados
<br>2019 -@Geovana Sousa
 	</footer>
</body>
</html>