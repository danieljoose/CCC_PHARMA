package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.RegisterNotFoundException;
import models.Administrador;
import repository.AdministradorRepository;

@Service
public class AdministradorService {

	private final String errorMessage = "Administrador não está cadastrado.";

	@Autowired
	private AdministradorRepository adminRepository;

	public List<Administrador> getAll() {
		return adminRepository.findAll();
	}

	public Administrador save(Administrador admin) {
		adminRepository.save(admin);
		return admin;
	}

	public Administrador findByCpf(String cpf) {

		Optional<Administrador> optAdmin = adminRepository.findByCpf(cpf);

		if (!optAdmin.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optAdmin.get();
	}
	
	public Administrador findByNome(String nome) {

		Optional<Administrador> optAdmin = adminRepository.findByNome(nome);

		if (!optAdmin.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optAdmin.get();
	}
}
