package com.example.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Produto {
	private String nome;
	private String codDeBarras;
	private String fabricante;
	private Situacao situacao;
	private Categoria categoria;
	private Double preco;
	private Date validade;
	private String lote;
	private int qntd;
	
	//nome, code de barras, fabricante, situacao e categoria
	public Produto(String nome, String codDeBarras, String fabricante,
			Situacao situacao, Categoria categoria) {
		this.nome = nome;
		this.codDeBarras = codDeBarras;
		this.fabricante = fabricante;
		this.situacao = situacao;
		this.categoria = categoria;
	}
	
	public Produto(String nome, String codDeBarras, String fabricante,
			Situacao situacao, Categoria categoria, float preco, int validadeDia,
			int validadeMes, int validadeAno, int qntd) {
		this.nome = nome;
		this.codDeBarras = codDeBarras;
		this.fabricante = fabricante;
		this.situacao = situacao;
		this.categoria = categoria;
		this.preco = (double) preco;
		this.validade = new Date(validadeAno - 1900, validadeMes - 1, validadeDia);
		this.lote = "";
		this.qntd = qntd;
	}
	
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public void setPreco(Double preco2) {
		this.preco = preco2;
	}

	
	
	
	@Override
	public String toString() {
		return ("Nome do Produto: " + this.nome + "Quantidade: " + this.qntd + "."); // FALTA TERMINAR AQUI
	}

	public int getQntd() {
		return this.qntd;
	}
	
	public void setQntd(int qntd){
		this.qntd = qntd;
	}
	
	public String getLote() {
		return this.lote;
	}
	
	public String getValidade() {
	    String[] data = this.validade.toString().split("-");
		return data[2] + "/" + data[1] + "/" + data[0];
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Double getPreco() {
		return this.preco;
	}
	
}
