package com.loja;

public class Fornecedor {
private int id;
private String razaoSocial;
private String cnpj;

public Fornecedor() {
}

public Fornecedor(int id, String razaoSocial, String cnpj) {
	this.id = id;
	this.razaoSocial = razaoSocial;
	this.cnpj = cnpj;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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

}
