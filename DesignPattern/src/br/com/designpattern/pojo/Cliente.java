package br.com.designpattern.pojo;

public class Cliente extends Fisica{
	private String cartaoCredito;
	private String status;
	
	public Cliente() {
	}
	
	public Cliente(String cartaoCredito, String status) {
		this.cartaoCredito = cartaoCredito;
		this.status = status;
	}
	
	
	public void setId(int id) {
		this .id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setRG(String rg) {
		this.rg = rg;
	}
	public String getRG() {
		return this.rg;
	}
	
	
	
	public void setContato(Contato contato) {
		this.contato=contato;
	}
	
	public Contato getContato() {
		return this.contato;
	}
	
	public String getCartaoCredito() {
		return cartaoCredito;
	}
	
	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
