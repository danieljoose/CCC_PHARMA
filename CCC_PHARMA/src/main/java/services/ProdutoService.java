package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import models.Produto;
import repository.ProdutoRepository;

@Service
public class ProdutoService {


    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        return this.produtoRepository.findAll();
    }
    
    public Produto cadastrar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

    public Produto findByNome(String nome) {
        return this.produtoRepository.findByNome(nome);
    }
    
    public Produto findByCodigo(String codigo) {
    	return this.produtoRepository.findByCodigo(codigo);
    }

    public Boolean getDisponibilidadeProduto(String nome) {
        Produto p = this.produtoRepository.findByNome(nome);
        return p.getSituacao();
    }

    public Double getPrecoProduto(String nome) {
        Produto p = this.produtoRepository.findByNome(nome);
        return p.getPreco();
    }
    
    public void setPrecoProduto(String nome, Double preco) {
        Produto p = this.produtoRepository.findByNome(nome);
        p.setPreco(preco);
    }
    
    public void deleteProduct(Produto p) {
    	this.produtoRepository.delete(p);
    }

	public List<Produto> orderByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produto> orderByNome() {
		// TODO Auto-generated method stub
		return null;
	}


  /**
   * CRIAR COMPARADORES
   */
}