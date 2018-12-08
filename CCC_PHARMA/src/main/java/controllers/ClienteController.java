package controllers;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Cliente;
import services.ClienteService;
 
@RestController // Indica que é um controle Rest, que já trata todas as transferências de objetos como Json.
@RequestMapping("value = /api") // Indica qual a url raiz do controller
@CrossOrigin(origins = "*") // Permite que o controller seja acessado por sistemas externos.
public class ClienteController {
 
	@Autowired
	ClienteService clienteService;
   
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public List<Cliente> getCliente() {
		return clienteService.getAll();
	}
	
	@RequestMapping(value = "/cliente/{cpf}", method = RequestMethod.GET)
	public Cliente getClienteByCpf(@PathVariable("cpf") String cpf) {
		return clienteService.findByCpf(cpf);
	}
	
	@RequestMapping(value = "/cliente/{nome}", method = RequestMethod.GET)
	public Cliente getClienteByNome(@PathVariable("nome") String nome) {
		return clienteService.findByNome(nome);
	}
}
