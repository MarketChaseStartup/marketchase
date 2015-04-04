package br.com.marketchase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketchase.models.services.AnuncioService;
import br.com.marketchase.enums.CategoriaAnuncio;
import br.com.marketchase.models.resources.AnuncioResource;

@RestController
@RequestMapping("/anuncio")
public class AnuncioController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<AnuncioResource> save(@RequestBody AnuncioResource resource){
		anuncioService.save(resource);
		return new ResponseEntity<AnuncioResource>(resource, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AnuncioResource resource){
		anuncioService.update(id, resource);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> desativarAtivarManual(@PathVariable Long id){
		anuncioService.desativarAtivarManual(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	public void desativarAutomatico(){
		anuncioService.desativarAutomatico();
	}
	
	public void ativarAutomatico(){
		anuncioService.ativarAutomatico();
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<AnuncioResource> find(@PathVariable Long id){
		AnuncioResource resource = anuncioService.find(id);
		return new ResponseEntity<AnuncioResource>(resource, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<AnuncioResource> findAll(){
		List<AnuncioResource> resources = anuncioService.findAll();
		return resources;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="loja/{loja}")
	public ResponseEntity<List<AnuncioResource>> findByLoja(@PathVariable Long loja){
		List<AnuncioResource> resources = anuncioService.findByLoja(loja);
		return new ResponseEntity<List<AnuncioResource>>(resources, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="categoria/{categoria}")
	public ResponseEntity<List<AnuncioResource>> findByCategoria(@PathVariable CategoriaAnuncio categoria){
		List<AnuncioResource> resources = anuncioService.findByCategoria(categoria);
		return new ResponseEntity<List<AnuncioResource>>(resources, HttpStatus.OK);
	}
}
