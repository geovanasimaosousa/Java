
package br.com.classes;
public class Usuario {
		//Declara��o dos atributos da classe Usu�rios
	public String login;
	public String senha;
	// Declara��o dos m�todos da classe Usu�rios
	public String cadastrar() {
		return ("Cadastro realizado com Sucesso!");
	}
	// Declara��o do m�todo logar para permitir o acesso ao sistema
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
	// Declara��o do m�todo logout
	public String logout() {
		return "Voc� saiu do aplicativo";
	}
}
