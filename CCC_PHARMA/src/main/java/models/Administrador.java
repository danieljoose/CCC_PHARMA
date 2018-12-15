package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "administrador")
@Entity
public class Administrador {

	@Id
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "password")
	private String password;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;
	
	 @Column(name = "admin")
	 @NotEmpty
	 private boolean admin;

	public Administrador() {
	}

	public Administrador(
			@NotEmpty(message = "'cpf' field may not be empty") @NotNull(message = "'cpf' field may not be null") String cpf,
			@NotEmpty(message = "'password' field may not be empty") @NotNull(message = "'password' field may not be null") String password,
			@NotEmpty(message = "'nome' field may not be empty") @NotNull(message = "'nome' field may not be null") String nome,
			@NotEmpty(message = "'email' field may not be empty") @NotNull(message = "'email' field may not be null") String email,
			@NotEmpty(message = "'telefone' field may not be empty") @NotNull(message = "'telefone' field may not be null") String telefone,
			boolean admin) {
		this.cpf = cpf;
		this.password = password;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.admin = admin;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isAdmin() {
		return true;
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
