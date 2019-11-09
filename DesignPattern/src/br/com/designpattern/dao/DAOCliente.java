package br.com.designpattern.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.com.designpattern.pojo.Cliente;
import br.com.designpattern.pojo.Contato;
import br.com.designpattern.pojo.Endereco;

public class DAOCliente extends Conexao implements ICrud<Cliente> {

	@Override
	public boolean cadastro(Cliente obj) {
		boolean retorno =true;
		try {
			conectar();
			String sqlEnd="insert into endereco(tipo, logradouro, numero, bairro, cep) values(?,?,?,?,?)";
				PreparedStatement pstEnd= con.prepareStatement(sqlEnd,Statement.RETURN_GENERATED_KEYS);
				pstEnd.setString(1, obj.getEndereco().getTipo());
				pstEnd.setString(2, obj.getEndereco().getLogradouro());
				pstEnd.setString(3, obj.getEndereco().getNumero());
				pstEnd.setString(4, obj.getEndereco().getBairro());
				pstEnd.setString(5, obj.getEndereco().getCep());
			
			//para pegar o id gerado no cadastro do endereco, iremos
			//usar o comando Statment.ReturnGeneredId
				int idEnd=pstEnd.executeUpdate();
				
				obj.getEndereco().setId(idEnd);
				
			String sqlCt="insert into contato(celular,email) values(?,?)";
				PreparedStatement pstCt= con.prepareStatement(sqlCt,Statement.RETURN_GENERATED_KEYS);
				pstCt.setString(1, obj.getContato().getCelular());
				pstCt.setString(2, obj.getContato().getEmail());
			
				int idCt=pstCt.executeUpdate();
				
				obj.getContato().setId(idCt);
			
			String sqlStr ="insert into cliente(nome,rg,cpf,cartaocredito,ativo,idendereco,idcontato) values(?,?,?,?,?,?,?)";
			pst =con.prepareStatement(sqlStr);
			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getRG());
			pst.setString(3, obj.getCpf());
			pst.setString(4, obj.getCartaoCredito());
			pst.setString(5, obj.getStatus());
			pst.setInt(6, obj.getEndereco().getId());
			pst.setInt(7, obj.getContato().getId());
			
			int x = pst.executeUpdate();
			if(x < 1)
				retorno = false;
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			retorno =false;
		}
		
		finally {
			try {con.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		return retorno;
	}

	
	public List<Cliente> buscar() {
		List<Cliente> lst = new ArrayList<Cliente>();
		try {
			conectar();
			String sqlStr ="Select * from cliente order by id desc";
			pst = con.prepareStatement(sqlStr);
			rs = pst.executeQuery();
			while(rs.next()) {
				Cliente cli = new Cliente();
				cli.setId(rs.getInt(1));
				cli.setNome(rs.getString(2));
				cli.setCPF(rs.getString(3));
				cli.setRG(rs.getString(4));
				cli.setCartaoCredito(rs.getString(5));
				cli.setStatus(rs.getString(6));
				
				Endereco end = new Endereco();
				end.setId(rs.getInt(7));
				cli.setEndereco(end);
				
				Contato ct = new Contato();
				end.setId(rs.getInt(8));
				cli.setContato(ct);
				
				lst.add(cli);
				
				
			}//while
		}//try
		catch(Exception ex){
			ex.printStackTrace();
			
		}//catch
		finally {
			try {con.close();}catch(Exception e) {e.printStackTrace();}
		}//finally
		
		return lst;
	}//fim do list

	@Override
	public Cliente busncar(int id) {
	
		return null;
	}

	@Override
	public boolean atualizar(Cliente obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean apagar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
