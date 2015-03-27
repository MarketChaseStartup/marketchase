package br.com.marketchase.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketchase.exceptions.LojaException;
import br.com.marketchase.models.domains.Contato;
import br.com.marketchase.models.domains.Endereco;
import br.com.marketchase.models.domains.Login;
import br.com.marketchase.models.domains.Loja;
import br.com.marketchase.models.repositories.LojaRepository;
import br.com.marketchase.models.resources.ContatoResource;
import br.com.marketchase.models.resources.EnderecoResource;
import br.com.marketchase.models.resources.JsonError;
import br.com.marketchase.models.resources.LojaResource;
import br.com.marketchase.parser.ContatoParser;
import br.com.marketchase.parser.EnderecoParser;
import br.com.marketchase.parser.LoginParser;
import br.com.marketchase.parser.LojaParser;

@Service
public class LojaService {

	@Autowired
	private LojaRepository lojaRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private LojaParser lojaParser;

	@Autowired
	private LoginParser loginParser;

	@Autowired
	private EnderecoParser enderecoParser;

	@Autowired
	private ContatoParser contatoParser;

	@Transactional
	public JsonError salvar(LojaResource lojaResource) throws LojaException {
		Loja loja = new Loja();
		loja = lojaParser.paraDomain(lojaResource, loja);

		Login login = new Login();
		loja.setLogin(loginParser.paraDomain(lojaResource.getLogin(), login));

		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		for (EnderecoResource e : lojaResource.getListaEnderecos()) {
			Endereco endereco = new Endereco();
			endereco = enderecoParser.paraDomain(e, endereco);
			
			Contato contato = new Contato();
			endereco.setListaContato(new ArrayList<Contato>());
			for (ContatoResource c : e.getListaContatos()) {
				contato = contatoParser.paraDomain(c, contato);
				
				endereco.getListaContato().add(contato);
			}
			listaEndereco.add(endereco);
		}
		loja.setListaEndereco(listaEndereco);
		lojaRepository.save(loja);
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(lojaResource);
		return objeto;
	}

	@Transactional
	public JsonError alterar(LojaResource lojaResource) throws LojaException {
		Loja loja = lojaRepository.findOneByCodigo(lojaResource.getCodigo());
		loja = lojaParser.paraDomain(lojaResource, loja);

		Login login = new Login();
		loja.setLogin(loginParser.paraDomain(lojaResource.getLogin(), login));

		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(lojaResource);
		return objeto;
	}

	@Transactional
	public JsonError desativarAtivar(LojaResource lojaResource)
			throws LojaException {
		Loja lojaRetorno = lojaRepository.findOneByCodigo(lojaResource
				.getCodigo());
		lojaRetorno.setAtiva(!(lojaRetorno.isAtiva()));
		lojaResource.setAtiva(!(lojaResource.isAtiva()));
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(lojaRetorno);
		return objeto;
	}

	@Transactional
	public JsonError Selecionar() throws LojaException {
		List<Loja> listaLojas = (List<Loja>) lojaRepository.findAll();
		List<LojaResource> listaLojasResource = new ArrayList<LojaResource>();
		for (Loja l : listaLojas) {
			LojaResource lojaResource = new LojaResource();
			lojaResource = lojaParser.paraResource(l, lojaResource);
			l.setListaEndereco(new ArrayList<Endereco>());
			for (Endereco e : l.getListaEndereco()) {
				EnderecoResource enderecoResource = new EnderecoResource();
				enderecoResource = enderecoParser.paraResource(e, enderecoResource);
				lojaResource.getListaEnderecos().add(enderecoResource);
			}
			listaLojasResource.add(lojaResource);
		}
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().addAll(listaLojasResource);
		return objeto;
	}
}