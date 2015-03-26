package br.com.marketchase.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Loja;


@Repository
public interface LojaRepository extends CrudRepository<Loja, Long> {
	
}
