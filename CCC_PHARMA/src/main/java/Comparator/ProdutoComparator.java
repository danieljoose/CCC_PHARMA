package Comparator;

import java.util.Comparator;

import models.Produto;

public class ProdutoComparator implements Comparator<Produto> {

	public static final int NOME = 1;
	public static final int PRECO = 2;
	public static final int VALIDADE = 3;
	public static final int QNTD = 4;
	int ordenar;

	public ProdutoComparator(int comparador) {
		this.ordenar = comparador;
	}

	@Override
	public int compare(Produto o1, Produto o2) {
		int retorno = 0;
		switch (this.ordenar) {
		case NOME:
			retorno = o1.getNome().compareTo(o2.getNome());
			break;
		case PRECO:
			retorno = o1.getPreco().compareTo(o2.getPreco());
			break;
		case VALIDADE:
			retorno = o1.getValidade().compareTo(o2.getValidade());
			break;
		case QNTD:
			retorno = Integer.compare(o1.getQntd(), o2.getQntd());
			break;
		default:
			throw new RuntimeException("Opcao Invalida");
		}
		return retorno;
	}
}