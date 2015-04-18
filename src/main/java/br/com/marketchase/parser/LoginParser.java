package br.com.marketchase.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.marketchase.models.domains.Login;
import br.com.marketchase.models.resources.LoginResource;

@Component
public class LoginParser implements ObjectParser<Login, LoginResource> {

	@Autowired
	private BCryptPasswordEncoder enconder;
	
	@Autowired 
	private BCryptPasswordEncoder encoder;
	
	@Override
	public Login paraDomain(LoginResource loginResource , Login login) {
		login.setCodigo(loginResource.getCodigo());
		login.setUsuario(loginResource.getUsuario());
		login.setSenha(encoder.encode(loginResource.getSenha()));
		return login;
	}

	@Override
	public LoginResource paraResource(Login login, LoginResource loginResource) {
		loginResource.setCodigo(login.getCodigo());
		loginResource.setUsuario(login.getUsuario());
		loginResource.setSenha(login.getSenha());
		return loginResource;
	}

}
