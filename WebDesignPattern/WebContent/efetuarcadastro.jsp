<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="br.com.designpattern.pojo.*" %>
   <%@ page import="br.com.designpattern.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Efetura Cadastro</title>
</head>
<body>
<%
String nome= request.getParameter("txtNome");

String rg = request.getParameter("txtRG");

String cpf = request.getParameter("txtCpf");

String cartao = request.getParameter("txtCartao");

String tipo = request.getParameter("txtTipo");

String logradouro = request.getParameter("txtLogradouro");

String numero = request.getParameter("txtNumero");

String bairro = request.getParameter("txtBairro");

String cep = request.getParameter("txtCep");

String celular = request.getParameter("txtCelular");

String email = request.getParameter("txtEmail");

String ativo = request.getParameter("rbtAtivo");

//vamo efetuar o cadastro passando os dados
//para o pojo e depois para a camada dao
Endereco end =new Endereco();
Contato ct =new Contato();
Cliente cli =new Cliente();

end.setTipo(tipo);
end.setLogradouro(logradouro);
end.setNumero(numero);
end.setBairro(bairro);
end.setCep(cep);

ct.setCelular(celular);
ct.setEmail(email);

cli.setNome(nome);
cli.setRG(rg);
cli.setCPF(cpf);
cli.setCartaoCredito(cartao);
cli.setEndereco(end);
cli.setContato(ct);

DAOCliente daoCli = new DAOCliente();

if(daoCli.cadastro(cli)){
	out.println("<h1>Cliente Cadastro com Sucesso!</h1>");
}
else{
	out.println("<h2>Não foi possivel cadastrar o cliente</h2>");
}
%>
</body>
</html>