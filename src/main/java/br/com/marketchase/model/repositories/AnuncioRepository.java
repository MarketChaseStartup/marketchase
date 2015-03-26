package br.com.marketchase.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marketchase.model.enums.AnuncioCategoria;
import br.com.marketchase.models.domains.Anuncio;
import br.com.marketchase.models.domains.Loja;

@Repository
public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {
	
	@Query("SELECT an FROM Anuncio an WHERE an.ativo = 'true' ORDER BY an.dataPostagem DESC")
	public List<Anuncio> findAll();
	
	@Query("SELECT an FROM Anuncio an INNER JOIN an.loja as loj WHERE loj.id = ?")
	public List<Anuncio> findByLoja(Long id);
	
	@Query("SELECT an FROM Anuncio an WHERE an.Categoria = ?")
	public List<Anuncio> findByCategoria(AnuncioCategoria categoria);
	
	@Query("SELECT an FROM Anuncio an WHERE an.ativo = 'true' AND an.permanente = 'true'")
	public List<Anuncio> findAtivosNaoPermanentes();
	
	@Query("SELECT an FROM Anuncio an WHERE an.ativo = 'false' AND an.permanente = 'true'")
	public List<Anuncio> findNaoAtivosNaoPermanentes();
}
