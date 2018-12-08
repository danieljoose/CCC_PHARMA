package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Produto;
import services.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoService productService;

	@RequestMapping(value = "/produtos/orderbyprice", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Produto> getProductsperPrice() {
		return this.productService.orderByPrice();
	}
	
	@RequestMapping(value = "/produtos/orderbyname", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Produto> getProductsperName() {
		return this.productService.orderByNome();
	}
	
	@RequestMapping(value = "/produtos/deletar", method = RequestMethod.DELETE)
	public String exluirProduto(String codigo) {
		Produto p = this.productService.findByCodigo(codigo);
		this.productService.deleteProduct(p);
		return "Produto excluído";
	}
	
	@RequestMapping(value = "/produtos/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Produto addProduct(@RequestBody Produto produto) {
		return this.productService.cadastrar(produto);
	}

	@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Produto> getProducts() {
		return this.productService.getAll();
	}
}