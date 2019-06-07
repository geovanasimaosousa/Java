package com.prjcadcliente.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prjcadcliente.dominio.Cliente;

/**
 * <b> CRUDCliente</b> <br>
 * Essa classe permite manipular as informação do cliente. Aqui você encontrar
 * os seguintes comandos;
 * <ul>
 * <li>Cadastro</li>
 * <li>Pesquisar por nome e por id</li>
 * <li>Atualizar</li>
 * <li>Deletar</li>
 * </ul>
 * 
 * @author geovana.ssousa
 *
 */

public class CRUDCliente {
	
	private Connection con = null; // Estabelecer a comunicação com o banco de dados
	private ResultSet rs = null; // Guardar os retorno dos selects no banco de dados
	private PreparedStatement pst = null;// Executar as consultas SQL

	public String cadastrar(Cliente cliente) {
		String msg = "";

		// criação dos objetivos para a conexão com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Colocar o caminho do banco de dado
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientedb?serverTimezone=UTC", "root", "");
			// as resposta do como o banco de dados
			String consulta = "INSERT INTO tbcliente(nome,email,telefone,idade)values(?,?,?,?)";
			pst = con.prepareStatement(consulta); // conexão com o banco de dado
			// insere um contato e passa por ai e responde
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			int r = pst.executeUpdate();
			// cadastrou ou não cadastrou
			if (r > 0)
				msg = "Cadastro realizado com sucesso!";
			else
				msg = "Não foi possivel cadastrar!";
		}
		// tratamento especifico para o banco de dados
		catch (SQLException ex) {
			msg = "Erro ao tentar Cadastrar:" + ex.getMessage();

		}
		// tratamento especifico para qual quer erro
		catch (Exception e) {
			msg = "Erro inesperado:" + e.getMessage();
		}
		// executar e fechar
		finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String atualizar(Cliente cliente) {
		String msg = "";

		// criação dos objetivos para a conexão com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientedb?serverTimezone=UTC", "root", "");
			// não se faz o update com where
			String consulta = "UPDATE tbcliente SET nome =? ,email=? ,telefone=? ,idade=? WHERE id=?";
			pst = con.prepareStatement(consulta);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			pst.setInt(5, cliente.getId());

			int r = pst.executeUpdate();

			if (r > 0)
				msg = "Atualizado com sucesso!";
			else
				msg = "Não foi possivel Atualizar!";
		} catch (SQLException ex) {
			msg = "Erro ao tentar Atualizar:" + ex.getMessage();

		} catch (Exception e) {
			msg = "Erro inesperado:" + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg;

	}

	public String deletar(Cliente cliente) {
		String msg = "";

		// criação dos objetivos para a conexão com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientedb?serverTimezone=UTC", "root", "");
			String consulta = "Delete FROM tbcliente WHERE id=?";
			pst = con.prepareStatement(consulta);
			// as resposta do como o banco de dados
			pst.setInt(1, cliente.getId());
			int r = pst.executeUpdate();

			if (r > 0)
				msg = "Delete com sucesso!";
			else
				msg = "Não foi possivel Deletar!";
		} catch (SQLException ex) {
			msg = "Erro ao tentar Deletar:" + ex.getMessage();

		} catch (Exception e) {
			msg = "Erro inesperado:" + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	public List<Cliente> PesquisarPorNome(String nome) {
		// array liste fica um do lado do outro
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			// carregar o drive de comunicação com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Chamar o gerenciador de driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306//clientedb?serverTimezone=UTC", "root", "");
			// Vamos criar a consulta para selecionar os clientes por nome
			String consulta = "Select * from tbcliente where nome=?";
			pst = con.prepareStatement(consulta);
			pst.setString(1, nome);
			// vamos executar a consulta e guardar o resultado na variável rs
			rs = pst.executeQuery();
			/*
			 * Vamos pegar um cliente por vez que esta no rs e adicioná-lo a lista de
			 * cliente para, então retorná-la
			 */
			while (rs.next()) {
				lista.add(new Cliente(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

			} // fim do while
		} // fim do try
		catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public Cliente PesquisarPorId(int id) {
		Cliente cliente = new Cliente();
		try {
			// carregar o drive de comunicação com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Chamar o gerenciador de driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306//clientedb?serverTimezone=UTC", "root", "");
			// Vamos criar a consulta para selecionar os clientes por nome
			String consulta = "Select * from tbcliente where id=?";
			pst = con.prepareStatement(consulta);
			pst.setInt(1, id);
			// vamos executar a consulta e guardar o resultado na variável rs
			rs = pst.executeQuery();
			/*
			 * Vamos pegar um cliente por vez que esta no rs e adicioná-lo a lista de
			 * cliente para, então retorná-la
			 */
			if (rs.next()) {
				cliente.setId(rs.getInt(0));
				cliente.setNome(rs.getString(1));
				cliente.setEmail(rs.getString(2));
				cliente.setTelefone(rs.getString(3));
				cliente.setIdade(rs.getInt(4));
			}
		} // fim do try
		catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}

	public List<Cliente> PesquisarTodos() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			// carregar o drive de comunicação com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Chamar o gerenciador de driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306//clientedb?serverTimezone=UTC", "root", "");
			// Vamos criar a consulta para selecionar os clientes por nome
			String consulta = "Select * from tbcliente";
			pst = con.prepareStatement(consulta);

			// vamos executar a consulta e guardar o resultado na variável rs
			rs = pst.executeQuery();
			/*
			 * Vamos pegar um cliente por vez que esta no rs e adicioná-lo a lista de
			 * cliente para, então retorná-la
			 */
			while (rs.next()) {
				lista.add(new Cliente(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

			} // fim do while
		} // fim do try
		catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}
