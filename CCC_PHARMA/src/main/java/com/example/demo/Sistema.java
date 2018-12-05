package com.example.demo;

import java.util.ArrayList;
import java.util.Map;

public class Sistema {
	Estoque estoque;
	ArrayList<Usuario> usuarios;
	

	public Sistema() {
		this.usuarios = new ArrayList<>();
	}

	public void salvar() {

	}

	public String cadastrarCliente(String nome, String cpf, String email, String telefone) {
		
		boolean logado = true;
		Cliente cliente = new Cliente(nome, logado, cpf, email, telefone);
		
		if (usuarios.contains(cliente)) {
			throw new IllegalArgumentException("Cliente já cadastrado");
		} else {
			usuarios.add(cliente);
			return "Cliente cadastrado com sucesso!";
		}
	}

	public String cadastrarAdministrador(String nome) {
		
		boolean logado = true;
		Administrador adm = new Administrador(nome,logado);
		
		if (usuarios.contains(adm)) {
			throw new IllegalArgumentException("Administrador já cadastrado");
		} else {
			usuarios.add(adm);
			return "Administrador cadastrado com sucesso!";
		}
	}
	
	/* 
	
	public String validarLogin() {   // FALTA TERMINAR

	} */

}
