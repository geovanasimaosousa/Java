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
 	
 	<input type="text" name="txtRG" id="txtRG" placeholder="RG do Cliente">
 	
 	<input type="text" name="txtCpf" id="txtCpf" placeholder="CPF do Cliente">
 	
 	<input type="text" name="txtCartao" id="txtCartao" placeholder="Número do cartão">
 	
 	<fieldset>
 	
 	<legend>Endereço:</legend>
 	<select type="text" name="txtTipo" id="txtTipo">
 	<option value="Rua">Rua</option>
 	<option value="Avenida">Avenida</option>
 	<option value="Estrada">Estrada</option>
 	<option value="Largo">Largo</option>
 	<option value="Praça">Praça</option>
 	<option value="Rodovia">Rodovia</option>
 	<option value="Alameda">Alameda</option>
 	</select>
 	
 	<input type="text" name="txtLogradouro" id="txtLogradouro" placeholder="Logradouro">
 	<input type="text" name="txtNumero" id="txtNumero" placeholder="Número">
 	<input type="text" name="txtBairro" id="txtBairro" placeholder="Bairro">
 	<input type="text" name="txtCep" id="txtCep" placeholder="CEP">
 		
 	</fieldset>
 	
 	<fieldset>
 	<legend>Contato:</legend>
 	<input type="text" name="txtCelular" id="txtCelular" placeholder="Celular">
 	<input type="text" name="txtEmail" id="txtEmail" placeholder="E-mail">
 	</fieldset>
<label>
<input type="radio" name="rbtAtivo" id="rbtAtivo" value="Sim">Sim
<input type="radio" name="rbtAtivo" id="rbtAtivo" value="Não">Não
</label> 	

 	<input type="submit" value="Cadastrar">
 	</form>
 	</main>
 	
 	 	
 	<footer>
 	Copyright - Todos os direitos reservados
<br>2019 -@Geovana Sousa
 	</footer>
</body>
</html>