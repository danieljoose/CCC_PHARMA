package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import models.Cliente;
import repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	public Cliente save(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}

	public Cliente findByCpf(String cpf) {

		return this.clienteRepository.findByCpf(cpf);
	}

	public Cliente findByNome(String nome) {

		return this.clienteRepository.findByNome(nome);
	}

	public void saveUser(Cliente cliente) {
		cliente.setAdmin(false);
		this.save(cliente);
	}
}
