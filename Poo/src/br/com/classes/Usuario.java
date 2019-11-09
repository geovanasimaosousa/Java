
package br.com.classes;
public class Usuario {
		//Declaração dos atributos da classe Usuários
	public String login;
	public String senha;
	// Declaração dos métodos da classe Usuários
	public String cadastrar() {
		return ("Cadastro realizado com Sucesso!");
	}
	// Declaração do método logar para permitir o acesso ao sistema
	public String logar() {
		String msg="";
		if(login.equals("adm") && senha.equals("123")) {
		msg ="Bem Vindo!";
	}
	else {
		msg ="Login ou senha incorreto";
		}
		return msg;
	}
	// Declaração do método logout
	public String logout() {
		return "Você saiu do aplicativo";
	}
}
