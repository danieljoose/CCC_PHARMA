package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

	List<Cliente> findAllByNomeIgnoreCaseContaining(String nome);

	List<Cliente> findAllByEmailIgnoreCaseContaining(String email);

	List<Cliente> findAllByTelefoneIgnoreCaseContaining(String telefone);

	@Query("SELECT a FROM Cliente a WHERE LOWER(a.cpf) LIKE CONCAT('%', LOWER(:cpf), '%')")
	public Optional<Cliente> findByCpf(@Param("cpf") String cpf);
	
	@Query("SELECT a FROM Cliente a WHERE LOWER(a.nome) LIKE CONCAT('%', LOWER(:nome), '%')")
	public Optional<Cliente> findByNome(@Param("nome") String nome);
}
