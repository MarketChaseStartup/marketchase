package br.com.marketchase.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.marketchase.models.repositories.LoginRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepositor;
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		return loginRepositor.findOneByusuario(usuario);
	}

}
