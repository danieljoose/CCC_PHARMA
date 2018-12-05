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

	public String cadastrarCliente() {
		Cliente cliente = new Cliente();
		if (usuarios.contains(cliente)) {
			throw new IllegalArgumentException("Cliente já cadastrado");
		} else {
			usuarios.add(cliente);
			return "Cliente cadastrado com sucesso!";
		}
	}

	public String cadastrarAdministrador() {
		Administrador adm = new Administrador();
		if (usuarios.contains(adm)) {
			throw new IllegalArgumentException("Administrador já cadastrado");
		} else {
			usuarios.add(adm);
			return "Administrador cadastrado com sucesso!";
		}
	}


	public String validarLogin() {

	}

}
