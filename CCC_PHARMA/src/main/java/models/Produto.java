package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nome")
	@NotNull(message = "Não pode ser nulo!")
	@NotEmpty(message = "Não pode ser vazio!")
	private String nome;

	@Column(name = "fabricante")
	@NotNull(message = "Não pode ser nulo!")
	@NotEmpty(message = "Não pode ser vazio!")
	private String fabricante;

	@Column(name = "situacao")
	@NotNull(message = "Não pode ser nula!")
	@NotEmpty(message = "Não pode ser vazia!")
	private boolean situacao;

	@Column(name = "categoria")
	@NotNull(message = "Não pode ser nula!")
	@NotEmpty(message = "Não pode ser vazia!")
	private String categoria;

	@Column(name = "preco")
	private Double preco;

	@Column(name = "quantidade")
	@NotNull(message = "Não pode ser nula!")
	@NotEmpty(message = "Não pode ser vazia!")
	private Integer quantidade;

	public Produto() {

	}

	public Produto(String codigo, String nome, String fabricante, boolean situacao, String categoria, Double preco,
			Integer quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.fabricante = fabricante;
		this.situacao = situacao;
		this.categoria = categoria;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return this.fabricante;
	}
	
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public boolean getSituacao() {
		return this.situacao;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQntd() {
		return quantidade;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = this.quantidade + quantidade;
	}

	public String getValidade() {
		// TODO Auto-generated method stub
		return null;
	}

}