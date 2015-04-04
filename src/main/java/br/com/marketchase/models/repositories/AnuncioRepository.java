package br.com.marketchase.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.models.domains.Anuncio;
import br.com.marketchase.enums.CategoriaAnuncio;

@Repository
public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {
	
	@Query("SELECT an FROM Anuncio an WHERE an.ativo = 'true' ORDER BY an.dataPostagem DESC")
	public List<Anuncio> findAll();
	
	@Query("SELECT an FROM Anuncio an INNER JOIN an.loja as loj WHERE loj.codigo = ? and an.ativo = 'true'")
	public List<Anuncio> findByLoja(Long id);
	
	@Query("SELECT an FROM Anuncio an WHERE an.categoria = ?")
	public List<Anuncio> findByCategoria(CategoriaAnuncio categoria);
	
	@Query("SELECT an FROM Anuncio an WHERE an.ativo = 'true' AND an.permanente = 'true'")
	public List<Anuncio> findByAtivoNaoPermanentes();
	
	@Query("SELECT an FROM Anuncio an WHERE an.ativo = 'false' AND an.permanente = 'true'")
	public List<Anuncio> findByNaoAtivosNaoPermanentes();
}
