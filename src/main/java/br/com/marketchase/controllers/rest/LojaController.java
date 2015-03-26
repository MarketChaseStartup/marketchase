package br.com.marketchase.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketchase.models.resources.JsonError;
import br.com.marketchase.models.resources.LojaResource;
import br.com.marketchase.models.service.LojaService;

@RestController
@RequestMapping("/lojas")
public class LojaController {

	@Autowired
	private LojaService lojaService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody LojaResource lojaResource){
		lojaService.salvar(lojaResource);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<JsonError> editar(@RequestBody LojaResource lojaResource){
		JsonError objeto = lojaService.alterar(lojaResource);
		return new ResponseEntity<>(objeto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> desativarAtivar(@RequestBody LojaResource lojaResource){
		lojaService.desativarAtivar(lojaResource);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/",method= RequestMethod.GET)
	public ResponseEntity<JsonError>selecionar(){
		JsonError objeto = lojaService.Selecionar();
		return new ResponseEntity<>(objeto,HttpStatus.OK);
	}
	
}
