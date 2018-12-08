package testes;
import com.example.demo.Categoria;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.Produto;
import com.example.demo.Situacao;

public class ProdutoTest {
	Produto produto;
	
	@Before
	public void instanciaProduto() {
		this.produto = new Produto("doril", "111", "CCC Botica", Situacao.DISPONIVEL,
				Categoria.MEDICAMENTOS, (float) 10.50, 22, 12, 2018, 10);
	}
	
	@Test
	public void getDateTest() {
		assertEquals("data errada", "22/12/2018", produto.getValidade());
	}

}
