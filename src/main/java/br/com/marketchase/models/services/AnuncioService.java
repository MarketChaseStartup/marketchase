package br.com.marketchase.models.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketchase.exceptions.AnuncioException;
import br.com.marketchase.models.repositories.AnuncioRepository;
import br.com.marketchase.models.repositories.LojaRepository;
import br.com.marketchase.models.domains.Anuncio;
import br.com.marketchase.models.enums.AnuncioCategoria;
import br.com.marketchase.models.resources.AnuncioResource;

@Service
public class AnuncioService {
	
	@Autowired
    private AnuncioRepository anuncioRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Transactional
	public Anuncio save(AnuncioResource resource){
		Anuncio anuncio = new Anuncio();
		
		if (resource.getDescricao() != null)
			anuncio.setDescricao(resource.getDescricao());
		anuncio.setNomeArquivo(resource.getNomeArquivo());
		anuncio.setTipoArquivo(resource.getTipoArquivo());
		anuncio.setCategoria(resource.getCategoria());
		anuncio.setDataPostagem(new Date());
		anuncio.setDataInicio(resource.getDataInicio());
		if (resource.getDataInicio().after(new Date()))
			anuncio.setAtivo(false);
		anuncio.setPermanente(resource.isPermanente());
		if (resource.isPermanente() == false)
			anuncio.setDataVencimento(resource.getDataVencimento());
		anuncio.setLoja(lojaRepository.findOne(resource.getIdLoja()));
		
		return anuncioRepository.save(anuncio);
	}
	
	@Transactional
	public Anuncio update(Long id, AnuncioResource resource){
		Anuncio anuncio = anuncioRepository.findOne(id);
		
		if (resource.getDescricao() != null)
			anuncio.setDescricao(resource.getDescricao());
		anuncio.setNomeArquivo(resource.getNomeArquivo());
		anuncio.setTipoArquivo(resource.getTipoArquivo());
		anuncio.setCategoria(resource.getCategoria());
		anuncio.setDataInicio(resource.getDataInicio());
		if (resource.getDataInicio().after(new Date()))
			anuncio.setAtivo(false);
		anuncio.setPermanente(resource.isPermanente());
		if (resource.isPermanente() == false)
			anuncio.setDataVencimento(resource.getDataVencimento());
		
		return anuncioRepository.save(anuncio);		
	}
	
	@Transactional
	public void desativarAutomatico(){
		List<Anuncio> anuncios = anuncioRepository.findAtivosNaoPermanentes();
		
		for (Anuncio anuncio : anuncios) {
		   if((anuncio.getDataVencimento().equals(new Date())) || (anuncio.getDataVencimento().before(new Date()))){
		       anuncio.setAtivo(false);
		       anuncioRepository.save(anuncio);
		   }
		}
	}
	
	@Transactional
	public void desativarManual(Long id){
		Anuncio anuncio = anuncioRepository.findOne(id);
		
		if((anuncio.getDataVencimento().equals(new Date())) || (anuncio.getDataVencimento().before(new Date()))){
		    anuncio.setAtivo(false);
		    anuncioRepository.save(anuncio);
		}
	}
	
	@Transactional
	public void sativarAutomatico(){
		List<Anuncio> anuncios = anuncioRepository.findNaoAtivosNaoPermanentes();
		
		for (Anuncio anuncio : anuncios) {
		   if((anuncio.getDataInicio().equals(new Date())) || (anuncio.getDataInicio().before(new Date()))){
		       anuncio.setAtivo(true);
		       anuncioRepository.save(anuncio);
		   }
		}
	}
	
	@Transactional
	public void ativarManual(Long id){
		Anuncio anuncio = anuncioRepository.findOne(id);
		
		if((anuncio.getDataInicio().equals(new Date())) || (anuncio.getDataInicio().before(new Date()))){
		    anuncio.setAtivo(true);
		    anuncioRepository.save(anuncio);
		}
	}
	
	@Transactional
	public AnuncioResource find(Long id){
		AnuncioResource resource = new AnuncioResource();
		
		Anuncio anuncio = anuncioRepository.findOne(id);		
		if (anuncio == null) throw new AnuncioException();

		if(anuncio.getDescricao() != null)
			resource.setDescricao(anuncio.getDescricao());
		resource.setNomeArquivo(anuncio.getCaminhoArquivo());
		resource.setTipoArquivo(anuncio.getTipoArquivo());
		resource.setCategoria(anuncio.getCategoria());
		resource.setDataPostagem(anuncio.getDataPostagem());
		resource.setDataInicio(anuncio.getDataInicio());
		resource.setPermanente(anuncio.isPermanente());
		if(anuncio.isPermanente() == false)
			resource.setDataVencimento(anuncio.getDataVencimento());		
		
		return resource;
	}
	
	@Transactional
	public List<AnuncioResource> findAll(){
		List<AnuncioResource> resources = new ArrayList<AnuncioResource>();
		
		List<Anuncio> anuncios = anuncioRepository.findAll();		
		if (anuncios == null) throw new AnuncioException();
		
		for (Anuncio anuncio : anuncios) {
			AnuncioResource resource = new AnuncioResource();
			
			if(anuncio.getDescricao() != null)
				resource.setDescricao(anuncio.getDescricao());
			resource.setNomeArquivo(anuncio.getCaminhoArquivo());
			resource.setTipoArquivo(anuncio.getTipoArquivo());
			resource.setCategoria(anuncio.getCategoria());
			resource.setDataPostagem(anuncio.getDataPostagem());
			resource.setDataInicio(anuncio.getDataInicio());
			resource.setPermanente(anuncio.isPermanente());
			if(anuncio.isPermanente() == false)
				resource.setDataVencimento(anuncio.getDataVencimento());
			
			resources.add(resource);
		}
		
		return resources;
	}
	
	@Transactional
	public List<AnuncioResource> findByLoja(Long id){
        List<AnuncioResource> resources = new ArrayList<AnuncioResource>();
		
		List<Anuncio> anuncios = anuncioRepository.findByLoja(id);		
		if (anuncios == null) throw new AnuncioException();
		
		for (Anuncio anuncio : anuncios) {
			AnuncioResource resource = new AnuncioResource();
			
			if(anuncio.getDescricao() != null)
				resource.setDescricao(anuncio.getDescricao());
			resource.setNomeArquivo(anuncio.getCaminhoArquivo());
			resource.setTipoArquivo(anuncio.getTipoArquivo());
			resource.setCategoria(anuncio.getCategoria());
			resource.setDataPostagem(anuncio.getDataPostagem());
			resource.setDataInicio(anuncio.getDataInicio());
			resource.setPermanente(anuncio.isPermanente());
			if(anuncio.isPermanente() == false)
				resource.setDataVencimento(anuncio.getDataVencimento());
			
			resources.add(resource);
		}
		
		return resources;
	}
	
	@Transactional
	public List<AnuncioResource> findByCategoria(AnuncioCategoria categoria){
        List<AnuncioResource> resources = new ArrayList<AnuncioResource>();
		
		List<Anuncio> anuncios = anuncioRepository.findByCategoria(categoria);		
		if (anuncios == null) throw new AnuncioException();
		
		for (Anuncio anuncio : anuncios) {
			AnuncioResource resource = new AnuncioResource();
			
			if(anuncio.getDescricao() != null)
				resource.setDescricao(anuncio.getDescricao());
			resource.setNomeArquivo(anuncio.getCaminhoArquivo());
			resource.setTipoArquivo(anuncio.getTipoArquivo());
			resource.setCategoria(anuncio.getCategoria());
			resource.setDataPostagem(anuncio.getDataPostagem());
			resource.setDataInicio(anuncio.getDataInicio());
			resource.setPermanente(anuncio.isPermanente());
			if(anuncio.isPermanente() == false)
				resource.setDataVencimento(anuncio.getDataVencimento());
			
			resources.add(resource);
		}
		
		return resources;
	}
}
