package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.RegisterNotFoundException;
import models.Cliente;
import repository.ClienteRepository;

@Service
public class ClienteService {

	private final String errorMessage = "Cliente não está cadastrado.";

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

		Optional<Cliente> optCliente = clienteRepository.findByCpf(cpf);

		if (!optCliente.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optCliente.get();
	}
	
	public Cliente findByNome(String nome) {

		Optional<Cliente> optCliente = clienteRepository.findByNome(nome);

		if (!optCliente.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optCliente.get();
	}
}
