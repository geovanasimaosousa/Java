package br.com.usarclasses;

import com.loja.Categoria;
import com.loja.Fornecedor;
import com.loja.Produto;

public class GerenciarProdutos {

	public static void main(String[] args) {
		/*
		 * Vamos criar um vetor (Array|Coleção) de Categoria
		 */
		Categoria[] cat = {
				new Categoria(11,"Infórmatica","Tecnologia"),
				new Categoria(12,"Suprimentos","Diversos"),
				new Categoria(13,"Escolar","Para o estudo")
		};
		Fornecedor[] fornecedor = {
				
				new Fornecedor(51,"Microsoft","111"),
				new Fornecedor(52,"Logitec","556"),
				new Fornecedor(53,"Tilibra","5548")
				};
		Produto pr = new Produto();
		pr.setId(60);
		pr.setNome("Mouse");
		pr.setDescrição("Mouse sem fio");
		pr.setCategoria(cat[0]);
		pr.setFornecedor(fornecedor[1]);
		pr.setPreco(20);
		}

}
