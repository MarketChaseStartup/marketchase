package br.com.marketchase.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

	public Loja findOneByCodigo(long codigo);

}
