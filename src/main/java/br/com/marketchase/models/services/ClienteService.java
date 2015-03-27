package br.com.marketchase.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketchase.models.repositories.ClienteRepository;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository ClienteRepository;
	
}
