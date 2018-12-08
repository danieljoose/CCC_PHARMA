package repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {

	List<Administrador> findAllByNomeIgnoreCaseContaining(String nome);

	List<Administrador> findAllByEmailIgnoreCaseContaining(String email);

	List<Administrador> findAllByTelefoneIgnoreCaseContaining(String telefone);
	
	@Query("SELECT a FROM Administrador a WHERE LOWER(a.cpf) LIKE CONCAT('%', LOWER(:cpf), '%')")
	public Optional<Administrador> findByCpf(@Param("cpf") String cpf);
	
	@Query("SELECT a FROM Administrador a WHERE LOWER(a.nome) LIKE CONCAT('%', LOWER(:nome), '%')")
	public Optional<Administrador> findByNome(@Param("nome") String nome);
}