package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name="cliente")
@Entity
public class Cliente {

	@Id
	@Column(name = "cpf")
	private String cpf;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	public Cliente() {
	}

	public Cliente(
			@NotEmpty(message = "'cpf' field may not be empty") @NotNull(message = "'cpf' field may not be null") String cpf,
			@NotEmpty(message = "'nome' field may not be empty") @NotNull(message = "'nome' field may not be null") String nome,
			@NotEmpty(message = "'email' field may not be empty") @NotNull(message = "'email' field may not be null") String email,
			@NotEmpty(message = "'telefone' field may not be empty") @NotNull(message = "'telefone' field may not be null") String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
