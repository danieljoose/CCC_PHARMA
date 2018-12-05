package com.example.demo;

public class Cliente extends Usuario{
	
	private String cpf;
	private String email;
	private String telefone;

	public Cliente(String nome, boolean logado, String cpf, String email, String telefone) {
		super(nome, logado);
		
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
