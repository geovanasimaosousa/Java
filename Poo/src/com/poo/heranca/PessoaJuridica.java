package com.poo.heranca;

public class PessoaJuridica extends Cliente {
	private String razaoSocial;
	private String cnpj;
	private String nomeFantasia;
	public PessoaJuridica() {
	}
	public PessoaJuridica(String razaoSocial, String cnpj, String nomeFantasia) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}
	public PessoaJuridica(String razaoSocial, String cnpj, String nomeFantasia, int id, String email, String telefone, String endereco){
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		super.setId(id);
		super.setEmail(email);
		super.setEndereco(endereco);
		super.setTelefone(telefone);
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	 @Override
	 public void cadastrar() {
		 System.out.println("Os dados do cliente foram cadastrados");
	 }
}
