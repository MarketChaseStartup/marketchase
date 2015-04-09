package br.com.marketchase.models.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import br.com.marketchase.models.domains.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {

	public Login findOneByusuario(String usuario);
	
}
