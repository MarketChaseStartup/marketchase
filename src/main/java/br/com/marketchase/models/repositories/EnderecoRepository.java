package br.com.marketchase.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	public Endereco findOneByCodigo(long codigo);
	
}
