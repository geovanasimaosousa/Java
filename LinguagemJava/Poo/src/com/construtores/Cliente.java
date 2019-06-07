package com.construtores;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	/*
	 * Métodos de acesso get set ....
	 */
	
	public void setId(int id) {
		this.id = id;
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
	public void setEmail(String emai) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	/*
	 * Sempre púplico
	 * Sempre com o mesmo nome da classe
	 * Não tipo tem tipo de retorno ou seja 
	 * Não é void ou Qualquer outro tipo
	 */
	public Cliente(int id, String nome, String email) {
		this.id =id;
		this.nome =nome;
		this.email =email;
	}
	
	public Cliente() {}
	
	public String cadastrar() {
		return "Cadastro realizado";
	}
	
	public String nomePorId(int id) {
		 String msg="";
		 if (this.id==id) {
			 msg = this.nome;
		 }
		 else {
			 msg = "Não localizar";
		 }
		 return msg;
	}
}
