package com.prjprodutos.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prjprodutos.dominio.Produtos;

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

public class CRUDProdutos {
	private Connection con = null; // Estabelecer a comunicação com o banco de dados
	private ResultSet rs = null; // Guardar os retorno dos selects no banco de dados
	private PreparedStatement pst = null;// Executar as consultas SQL

	public String cadastrar(Produtos produtos) {
		String msg = "";

		// criação dos objetivos para a conexão com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Colocar o caminho do banco de dado
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprodutos?serverTimezone=UTC", "root", "");
			// as resposta do como o banco de dados
			String consulta = "INSERT INTO tbprodutos(nome,descricao,fabricante,quantidade,preco)values(?,?,?,?,?)";
			pst = con.prepareStatement(consulta); // conexão com o banco de dado
			// insere um contato e passa por ai e responde
			pst.setString(1, produtos.getNome());
			pst.setString(2, produtos.getDescricao());
			pst.setString(3, produtos.getFabricante());
			pst.setInt(4, produtos.getQuantidade());
			pst.setDouble(5, produtos.getPreco());
			int r = pst.executeUpdate();
			// cadastrou ou não cadastrou
			if (r > 0)
				msg = "Cadastro o seu produto foi cadastrado com sucesso";
			else
				msg = "Não foi possivel cadastrar o seu produto!";
		}
		// tratamento especifico para o banco de dados
		catch (SQLException ex) {
			msg = "Erro ao tentar Cadastrar o seu produto:" + ex.getMessage();

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

	public String atualizar(Produtos produtos) {
		String msg = "";

		// criação dos objetivos para a conexão com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprodutos?serverTimezone=UTC", "root", "");
			// não se faz o update com where
			String consulta = "UPDATE dbprodutos SET nome =? ,descricao=? ,fabricante=?,quantidade=? ,preco=? WHERE id=?";
			pst = con.prepareStatement(consulta);
			pst.setString(1, produtos.getNome());
			pst.setString(2, produtos.getDescricao());
			pst.setString(3, produtos.getFabricante());
			pst.setInt(3, produtos.getQuantidade());
			pst.setDouble(5, produtos.getPreco());
			pst.setInt(6, produtos.getId());

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

	public String deletar(Produtos produtos) {
		String msg = "";

		// criação dos objetivos para a conexão com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprodutos?serverTimezone=UTC", "root", "");
			String consulta = "Delete FROM dbprodutos WHERE id=?";
			pst = con.prepareStatement(consulta);
			// as resposta do como o banco de dados
			pst.setInt(1, produtos.getId());
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

	public List<Produtos> PesquisarPorNome(String nome) {
		// array liste fica um do lado do outro
		List<Produtos> lista = new ArrayList<Produtos>();
		try {
			// carregar o drive de comunicação com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Chamar o gerenciador de driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306//dbprodutos?serverTimezone=UTC", "root", "");
			// Vamos criar a consulta para selecionar os clientes por nome
			String consulta = "Select * from dbprodutos where nome=?";
			pst = con.prepareStatement(consulta);
			pst.setString(1, nome);
			// vamos executar a consulta e guardar o resultado na variável rs
			rs = pst.executeQuery();
			/*
			 * Vamos pegar um cliente por vez que esta no rs e adicioná-lo a lista de
			 * cliente para, então retorná-la
			 */
			while (rs.next()) {
				lista.add(new Produtos(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));

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

	public Produtos PesquisarPorId(int id) {
		Produtos produtos = new Produtos();
		try {
			// carregar o drive de comunicação com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Chamar o gerenciador de driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprodutos?serverTimezone=UTC", "root", "");
			// Vamos criar a consulta para selecionar os clientes por nome
			String consulta = "Select * from dbprodutos where id=?";
			pst = con.prepareStatement(consulta);
			pst.setInt(1, id);
			// vamos executar a consulta e guardar o resultado na variável rs
			rs = pst.executeQuery();
			/*
			 * Vamos pegar um cliente por vez que esta no rs e adicioná-lo a lista de
			 * cliente para, então retorná-la
			 */
			if (rs.next()) {
				produtos.setId(rs.getInt(0));
				produtos.setNome(rs.getString(1));
				produtos.setDescricao(rs.getString(2));
				produtos.setFabricante(rs.getString(3));
				produtos.setQuantidade(rs.getInt(4));
				produtos.setPreco(rs.getDouble(5));
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
		return produtos;
	}

	public List<Produtos> PesquisarTodos() {
		List<Produtos> lista = new ArrayList<Produtos>();
		try {
			// carregar o drive de comunicação com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Chamar o gerenciador de driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprodutos?serverTimezone=UTC", "root", "");
			// Vamos criar a consulta para selecionar os clientes por nome
			String consulta = "Select * from dbprodutos";
			pst = con.prepareStatement(consulta);

			// vamos executar a consulta e guardar o resultado na variável rs
			rs = pst.executeQuery();
			/*
			 * Vamos pegar um cliente por vez que esta no rs e adicioná-lo a lista de
			 * cliente para, então retorná-la
			 */
			while (rs.next()) {
				lista.add(new Produtos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6)));

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

