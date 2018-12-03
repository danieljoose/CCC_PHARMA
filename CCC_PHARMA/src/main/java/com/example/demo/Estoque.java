package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Estoque {
	Map<String, Produto> produtos;
	Map<String, Produto> produtosEmFalta;
	Map<String, Produto> produtosVencidos;
	
	public Estoque() {
		produtos = new HashMap<>();
		produtosEmFalta = new HashMap<>();
		produtosVencidos = new HashMap<>();
	}
	
	public void addProduto(Produto produto) {
		produtos.put(produto.getNome(), produto);
	}
	
	public String consultaDisponibilidadeEPreco(String nomeProduto, String lote) {
		if(qntdProdutosIgualZero(nomeProduto) || loteEstaVencido(lote)) {
			marcarProdutoComoIndispisponivel(nomeProduto);
			return "Produto Indisponivel";
		}
		else {
			String nome = this.produtos.get(nomeProduto).getNome();
			float preco = this.produtos.get(nomeProduto).getPreco();
			int qntd = this.produtos.get(nomeProduto).getQntd();
			
			return nome + " - " + preco + " - " + qntd;
		}
		
		
	}
	
	public boolean loteEstaVencido(String lote) {
		boolean result = false;
		String dataAtual = new Date(System.currentTimeMillis()).toString();
		for(Produto produto : this.produtos.values()) {
			if(produto.getLote().equals(lote) && 
					produto.getValidade().compareTo(dataAtual) < 0) {
				result = true;
				return result;
			}
		}
		return result;
	}
	
	public boolean qntdProdutosIgualZero(String nomeProduto) {
		if(this.produtos.get(nomeProduto).getQntd() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void atribuirPreco(String nomeProduto, float preco) {
		this.produtos.get(nomeProduto).setPreco(preco);
	}
	
	public void marcarProdutoComoIndispisponivel(String nomeProduto) {
		this.produtos.get(nomeProduto).setSituacao(Situacao.NAO_DISPONIVEL);
	}
	
	public int qntdProdutos(String nomeProduto) {
		return this.produtos.get(nomeProduto).getQntd();
	}
	

}
