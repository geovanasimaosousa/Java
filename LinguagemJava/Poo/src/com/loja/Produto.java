package com.loja;

public class Produto {
	private int id;
	private String nome;
	private String descri��o;
	private Categoria categoria;
	private Fornecedor fornecedor;
	private double preco;
	//bot�o direito source -
	public Produto() {
	}
	
	public Produto(int id, String nome, String descri��o, Categoria categoria, Fornecedor fornecedor, double preco) {
		this.id = id;
		this.nome = nome;
		this.descri��o = descri��o;
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
	public String getDescri��o() {
		return descri��o;
	}
	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
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
