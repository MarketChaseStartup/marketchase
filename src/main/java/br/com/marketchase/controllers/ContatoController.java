package br.com.marketchase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketchase.models.resources.ContatoResource;
import br.com.marketchase.models.services.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody ContatoResource contatoResource){
		contatoService.salvar(contatoResource);
		return new ResponseEntity<String> (HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<String> editar(@RequestBody ContatoResource contatoResource){
		contatoService.editar(contatoResource);
		return new ResponseEntity<String> (HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@RequestBody ContatoResource contatoResource){
		contatoService.excluir(contatoResource);
		return new ResponseEntity<String> (HttpStatus.CREATED);
	}
	
}
