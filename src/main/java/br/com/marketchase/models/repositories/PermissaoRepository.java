package br.com.marketchase.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	public Permissao findOneBynome(String nome);
	
}
