package br.com.marketchase.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	public Login findOneByusuario(String usuario);
	
}
