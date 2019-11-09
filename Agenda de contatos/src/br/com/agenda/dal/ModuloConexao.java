package br.com.agenda.dal;

import java.sql.*;

public class ModuloConexao {
	// A classe abaixo cria um m�todo de conex�o com retorno
	public static Connection conector() {
		// Criando uma vari�vel para receber a conex�o
		java.sql.Connection conexao = null;
		String driver = "com.mysql.jdbc.Driver";
		// Vari�vel que recebe as informa��o do banco
		String url = "jdbc:mysql://10.26.45.109:3306/agenda?useSSL=false";
		// autentica��o
		String user = "admin";
		String password = "123@Senac";
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} 
		//caso ocorra exce��o
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
