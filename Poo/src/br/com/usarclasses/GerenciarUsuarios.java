package br.com.usarclasses;

import br.com.classes.Usuario;

public class GerenciarUsuarios {

	public static void main(String[] args) {
		Usuario us = new Usuario();
		us.login = "adm";
		us.senha = "123";
		//us.cadastrar();
		//us.logar();
		us.logout();

	}

}
