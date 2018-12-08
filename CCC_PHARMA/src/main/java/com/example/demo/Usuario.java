package com.example.demo;


public abstract class Usuario {

	private String nome;
	private boolean logado;
	
	
	public Usuario(String nome, boolean logado) {
		super();
		this.nome = nome;
		this.logado = logado;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public boolean getLogado() {
		return logado;
	}


	public void setLogado(boolean logado) {
		this.logado = logado;
	}	
    
}

 
 