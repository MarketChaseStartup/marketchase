package br.com.marketchase.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	public Endereco findOneByCodigo(long codigo);
	
}
