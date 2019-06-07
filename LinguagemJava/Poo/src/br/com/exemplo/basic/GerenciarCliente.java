package br.com.exemplo.basic;

import com.construtores.Cliente;

public class GerenciarCliente {

	public static void main(String[] args) {
		// Instância da classe cliente
		 
		 Cliente cl2 = new Cliente();
		 cl2.setId(10);
		 cl2.setNome("Bruno");
		 cl2.setEmail("bruno@terra.com.br");
		 System.out.println(cl2.nomePorId(10));

	}

}
