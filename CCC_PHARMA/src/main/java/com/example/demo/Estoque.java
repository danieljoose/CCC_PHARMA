package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Estoque {
	ArrayList<Produto> produtos;
	ArrayList<Produto> produtosEmFalta;
	ArrayList<Produto> produtosVencidos;
	ArrayList<Produto> produtosVendidos;

	public Estoque() {
		produtos = new ArrayList<>();
		produtosEmFalta = new ArrayList<>();
		produtosVencidos = new ArrayList<>();
		produtosVendidos = new ArrayList<>();
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

	public String consultaDisponibilidadeEPreco(String nomeProduto, String lote) {

		if (qntdProdutosIgualZero(nomeProduto) || loteEstaVencido(lote)) {
			marcarProdutoComoIndispisponivel(nomeProduto);
			return "Produto Indisponivel";
		} else {
			String retorno = "";
			for (int i = 0; i < this.produtos.size(); i++) {
				if (this.produtos.get(i).getNome().equals(nomeProduto)) {
					String nome = this.produtos.get(i).getNome();
					Double preco = (double) this.produtos.get(i).getPreco();
					int qntd = this.produtos.get(i).getQntd();

					retorno = nome + " - " + preco + " - " + qntd;
				}
			}

			return retorno;
		}

	}

	public boolean loteEstaVencido(String lote) {
		boolean result = false;
		String dataAtual = new Date(System.currentTimeMillis()).toString();
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getLote().equals(lote) && produtos.get(i).getValidade().compareTo(dataAtual) < 0) {
				result = true;
				return result;
			}
		}
		return result;
	}

	public boolean qntdProdutosIgualZero(String nomeProduto) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getNome().equals(nomeProduto)) {
				if (this.produtos.get(i).getQntd() == 0) {
					return true;

				}
			}
		}
		return false;
	}

	public void atribuirPreco(String nomeProduto, Double preco) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getNome().equals(nomeProduto)) {
				this.produtos.get(i).setPreco(preco);
			}
		}
	}

	public void marcarProdutoComoIndispisponivel(String nomeProduto) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getNome().equals(nomeProduto)) {
				this.produtos.get(i).setSituacao(Situacao.NAO_DISPONIVEL);
			}
		}

	}

	public int qntdProdutos(String nomeProduto) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getNome().equals(nomeProduto)) {
				return this.produtos.get(i).getQntd();
			}
		}
		return 0;
	}
	
	public void descontoEmCategoria(Categoria categoria,int desconto) {
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getCategoria().equals(categoria)) {
				double precoDoDesconto = produtos.get(i).getPreco()*desconto;
				produtos.get(i).setPreco(produtos.get(i).getPreco() - precoDoDesconto);
			}
		}
	}
	
	// Metodo nao esta pronto, falta terminar 
	public String relatorioGeral() {
		String saida = "";
		for(int i = 0; i < produtos.size(); i++) {
			saida += "(" + i + ") " + produtos.get(i).toString()+".\n";
		}
		return saida;
	}
	
	
	public void ordenarProdutoNome() {
		Collections.sort(produtos, new ComparatorProduto(ComparatorProduto.NOME));
	}
	
	public void ordenarProdutoPreco() {
		Collections.sort(produtos, new ComparatorProduto(ComparatorProduto.PRECO));
	}
	
	public void ordenarProdutoValidade() {
		Collections.sort(produtos, new ComparatorProduto(ComparatorProduto.VALIDADE));
	}
	
	public void ordenarProdutoQntd() {
		Collections.sort(produtos, new ComparatorProduto(ComparatorProduto.QNTD));
	}

	
}
