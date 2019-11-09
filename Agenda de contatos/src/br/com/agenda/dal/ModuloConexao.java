package br.com.agenda.dal;

import java.sql.*;

public class ModuloConexao {
	// A classe abaixo cria um método de conexão com retorno
	public static Connection conector() {
		// Criando uma variável para receber a conexão
		java.sql.Connection conexao = null;
		String driver = "com.mysql.jdbc.Driver";
		// Variável que recebe as informação do banco
		String url = "jdbc:mysql://10.26.45.109:3306/agenda?useSSL=false";
		// autenticação
		String user = "admin";
		String password = "123@Senac";
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} 
		//caso ocorra exceção
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
