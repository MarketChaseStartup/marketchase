package br.com.marketchase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketchase.models.resources.EnderecoResource;
import br.com.marketchase.models.resources.JsonError;
import br.com.marketchase.models.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<JsonError> salvar(@RequestBody EnderecoResource enderecoResource){
		JsonError objeto = enderecoService.salvar(enderecoResource);
		return new ResponseEntity<JsonError>(objeto,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<String> editar(@RequestBody EnderecoResource enderecoResource){
		enderecoService.editar(enderecoResource);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@RequestBody EnderecoResource enderecoResource){
		enderecoService.excluir(enderecoResource);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
}
