package br.com.marketchase.models.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketchase.enums.CategoriaAnuncio;
import br.com.marketchase.exceptions.AnuncioException;
import br.com.marketchase.models.domains.Anuncio;
import br.com.marketchase.models.domains.Loja;
import br.com.marketchase.models.repositories.AnuncioRepository;
import br.com.marketchase.models.repositories.LojaRepository;
import br.com.marketchase.models.resources.AnuncioResource;
import br.com.marketchase.parser.AnuncioParser;

@Service
public class AnuncioService {
	
	@Autowired
    private AnuncioRepository anuncioRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private AnuncioParser anuncioParser;
	
	@Transactional
	public long save(AnuncioResource anuncioResource){
		Anuncio anuncio = new Anuncio();		
		anuncio.setDataPostagem(new Date());
		anuncioResource.setDataPostagem(new Date());
		
		anuncio = anuncioParser.paraDomain(anuncioResource, anuncio);
		
		Loja loja = lojaRepository.findOne(anuncioResource.getLoja().getCodigo());
		anuncio.setLoja(loja);
		loja.setListaAnuncios(new ArrayList<Anuncio>());
		loja.getListaAnuncios().add(anuncio);
		
		anuncioRepository.save(anuncio);
		
		return anuncio.getCodigo();
	}
	
	@Transactional
	public Anuncio update(Long id, AnuncioResource anuncioResource){
		Anuncio anuncio = new  Anuncio();
		
		anuncio = anuncioParser.paraDomain(anuncioResource, anuncio);
		
		return anuncioRepository.saveAndFlush(anuncio);		
	}
	
	@Transactional
	public void desativarAtivarManual(Long id){
		Anuncio anuncio = anuncioRepository.findOne(id);
		
		anuncio.setAtivo(!(anuncio.isAtivo()));
		anuncioRepository.save(anuncio);
	}
	
	@Transactional
	public void desativarAutomatico(){
		List<Anuncio> anuncios = anuncioRepository.findByAtivoNaoPermanentes();
		
		for (Anuncio anuncio : anuncios) {
		   if((anuncio.getDataHoraVencimento().equals(new Date())) || (anuncio.getDataHoraVencimento().before(new Date()))){
		       anuncio.setAtivo(false);
		       anuncioRepository.save(anuncio);
		   }
		}
	}
	
	@Transactional
	public void ativarAutomatico(){
		List<Anuncio> anuncios = anuncioRepository.findByNaoAtivosNaoPermanentes();
		
		for (Anuncio anuncio : anuncios) {
		   if((anuncio.getDataHoraInicio().equals(new Date())) || (anuncio.getDataHoraInicio().before(new Date()))){
		       anuncio.setAtivo(true);
		       anuncioRepository.save(anuncio);
		   }
		}
	}
	
	@Transactional
	public AnuncioResource find(Long id){
		AnuncioResource anuncioResource = new AnuncioResource();
		
		Anuncio anuncio = anuncioRepository.findOne(id);		
		if (anuncio == null) throw new AnuncioException();
		
		anuncioResource = anuncioParser.paraResource(anuncio, anuncioResource);		
		
		return anuncioResource;
	}
	
	@Transactional
	public List<AnuncioResource> findAll(){
		List<AnuncioResource> resources = new ArrayList<AnuncioResource>();
		
		List<Anuncio> anuncios = anuncioRepository.findAll();		
		if (anuncios == null) throw new AnuncioException();
		
		for (Anuncio anuncio : anuncios) {
			AnuncioResource anuncioResource = new AnuncioResource();
			
			anuncioResource = anuncioParser.paraResource(anuncio, anuncioResource);	
			
			resources.add(anuncioResource);
		}
		
		return resources;
	}
	
	@Transactional
	public List<AnuncioResource> findByLoja(Long id){
        List<AnuncioResource> resources = new ArrayList<AnuncioResource>();
		
		List<Anuncio> anuncios = anuncioRepository.findByLoja(id);		
		if (anuncios == null) throw new AnuncioException();
		
		for (Anuncio anuncio : anuncios) {
			AnuncioResource anuncioResource = new AnuncioResource();
			
			anuncioResource = anuncioParser.paraResource(anuncio, anuncioResource);	
			
			resources.add(anuncioResource);
		}
		
		return resources;
	}
	
	@Transactional
	public List<AnuncioResource> findByCategoria(CategoriaAnuncio categoria){
        List<AnuncioResource> resources = new ArrayList<AnuncioResource>();
		
		List<Anuncio> anuncios = anuncioRepository.findByCategoria(categoria);		
		if (anuncios == null) throw new AnuncioException();
		
		for (Anuncio anuncio : anuncios) {
			AnuncioResource anuncioResource = new AnuncioResource();
			
			anuncioResource = anuncioParser.paraResource(anuncio, anuncioResource);	
			
			resources.add(anuncioResource);
		}
		
		return resources;
	}
}
