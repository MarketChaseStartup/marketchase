package br.com.marketchase.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	

}
