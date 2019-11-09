package com.loja;

public class Produto {
	private int id;
	private String nome;
	private String descrição;
	private Categoria categoria;
	private Fornecedor fornecedor;
	private double preco;
	//botão direito source -
	public Produto() {
	}
	
	public Produto(int id, String nome, String descrição, Categoria categoria, Fornecedor fornecedor, double preco) {
		this.id = id;
		this.nome = nome;
		this.descrição = descrição;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
