package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Administrador;
import services.AdministradorService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AdministradorController {
	
	@Autowired
	AdministradorService adminService;
	
	@RequestMapping(value = "/administrador", method = RequestMethod.POST)
	public Administrador save(@RequestBody Administrador admin) {
		return adminService.save(admin);
	}

	@RequestMapping(value = "/administrador", method = RequestMethod.GET)
	public List<Administrador> getAdmin() {
		return adminService.getAll();
	}
	
	@RequestMapping(value = "/administrador/{cpf}", method = RequestMethod.GET)
	public Administrador getAdminByCpf(@PathVariable("cpf") String cpf) {
		return adminService.findByCpf(cpf);
	}
	
	@RequestMapping(value = "/administrador/{nome}", method = RequestMethod.GET)
	public Administrador getAdminByNome(@PathVariable("nome") String nome) {
		return adminService.findByNome(nome);
	}
}
