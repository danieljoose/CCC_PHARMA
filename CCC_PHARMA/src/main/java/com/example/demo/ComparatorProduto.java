package com.example.demo;

import java.util.Comparator;

public class ComparatorProduto implements Comparator<Produto> {
	public static final int NOME = 1;
	public static final int PRECO = 2;
	public static final int VALIDADE = 3;
	public static final int QNTD = 4;
	int ordenar;

	public ComparatorProduto(int ordenar) {
		this.ordenar = ordenar;
	}

	@Override
	public int compare(Produto o1, Produto o2) {
		int retorno = 0;
		switch (this.ordenar) {
		case NOME:
			retorno = o1.getNome().compareTo(o2.getNome());
			break;
		case PRECO:
			retorno = Double.compare(o1.getPreco(), o2.getPreco());
			break;
		case VALIDADE:
			retorno = o1.getValidade().compareTo(o2.getValidade());
			break;
		case QNTD:
			retorno = Integer.compare(o1.getQntd(), o2.getQntd());
			break;
		default:
			throw new RuntimeException("Nao existe opcao");
		}
		return retorno;
	}
}