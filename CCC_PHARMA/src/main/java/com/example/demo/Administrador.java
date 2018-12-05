package com.example.demo;

public class Administrador extends Usuario {

	public Estoque estoque;
	public Categoria categoria;

	public Administrador(String nome, boolean logado) {
		super(nome, logado);
	}

	public void adicionaProduto(String nome, String codDeBarras, String fabricante, Situacao situacao,
			Categoria categoria) {
		Produto novoProduto = new Produto(nome, codDeBarras, fabricante, situacao, categoria);
		estoque.addProduto(novoProduto);
	}

	public void ordenarProdutos(String ordenar) {
		if (ordenar.equals("nome")) {
			estoque.ordenarProdutoNome();
		} else if (ordenar.equals("preco")) {
			estoque.ordenarProdutoPreco();
		} else if (ordenar.equals("categoria")) {
			// FALTA IMPLEMENTAR ORDENAR POR CATEGORIA
		}
	}

	public void ordenarRegistrosDeVenda(String ordenar) {
		if (ordenar.equals("nome")) {
			// FALTA IMPLEMENTAR
		} else if (ordenar.equals("preco")) {
			// FALTA IMPLEMENTAR
		} else if (ordenar.equals("categoria")) {
			// FALTA IMPLEMENTAR ORDENAR POR CATEGORIA
		} else if (ordenar.equals("data")) {
			// FALTA IMPLEMENTAR
		}
	}

	// MEDICAMENTOS, HIGIENE_PESSOAL, COSMETICOS, ALIMENTOS;
	public void adicionarDescontoEmCategoria(Categoria categoria, int desconto) {
		int porcentagem = desconto/100;
		estoque.descontoEmCategoria(categoria, porcentagem);
	}
	
	public String relatorioGeral() {
		return estoque.relatorioGeral();
	}
	
	public String consultarDisponibilidadeEpreco(String nomeProduto, String lote) {
		return estoque.consultaDisponibilidadeEPreco(nomeProduto, lote);
	}
}
