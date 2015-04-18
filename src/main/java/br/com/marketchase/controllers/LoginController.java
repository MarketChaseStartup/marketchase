package br.com.marketchase.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketchase.models.domains.Login;
import br.com.marketchase.models.repositories.LoginRepository;
import br.com.marketchase.models.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private static final int CREDENTIAL_INDEX = 6;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginRepository loginRepository;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Long> logar(@RequestHeader MultiValueMap<String,String> headers){
		Map<String,String> parametros = loginService.prepareParameters(headers);
		String dados = parametros.get("Authorization").substring(CREDENTIAL_INDEX);
		String usuario = loginService.decodificaCredenciais(dados);
		Login login = loginRepository.findOneByusuario(usuario);
		login.setSenha(null);
		return new ResponseEntity<>(login.getCodigo(),HttpStatus.OK);
		
	}
	
}
