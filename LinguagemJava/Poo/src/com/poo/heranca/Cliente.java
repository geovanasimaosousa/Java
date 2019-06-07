package com.poo.heranca;

public abstract class Cliente {
	
	private int id;
	private String email;
	private String  endereco;
	private String telefone;
	
	public void cadastrar() {
	}
		public String localizar (int id) {
			return null;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

}
