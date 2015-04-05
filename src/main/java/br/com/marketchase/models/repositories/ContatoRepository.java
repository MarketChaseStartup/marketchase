package br.com.marketchase.models.repositories;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	public Contato findOneByCodigo(long codigo);

}
