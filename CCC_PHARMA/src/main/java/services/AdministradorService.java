package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import models.Administrador;
import repository.AdministradorRepository;

@Service
public class AdministradorService {


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

		return this.adminRepository.findByCpf(cpf);
	}
	
	public Administrador findByNome(String nome) {

		return this.adminRepository.findByNome(nome);
	}
	
}
