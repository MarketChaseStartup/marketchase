package br.com.marketchase.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketchase.exceptions.EnderecoException;
import br.com.marketchase.models.domains.Contato;
import br.com.marketchase.models.domains.Endereco;
import br.com.marketchase.models.domains.Loja;
import br.com.marketchase.models.repositories.EnderecoRepository;
import br.com.marketchase.models.repositories.LojaRepository;
import br.com.marketchase.models.resources.ContatoResource;
import br.com.marketchase.models.resources.EnderecoResource;
import br.com.marketchase.models.resources.JsonError;
import br.com.marketchase.parser.ContatoParser;
import br.com.marketchase.parser.EnderecoParser;
import br.com.marketchase.parser.LoginParser;
import br.com.marketchase.parser.LojaParser;

@Service
public class EnderecoService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private LojaParser lojaParser;

	@Autowired
	private LoginParser loginParser;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private LojaRepository lojaRepository;

	@Autowired
	private EnderecoParser enderecoParser;

	@Autowired
	private ContatoParser contatoParser;

	@Transactional
	public JsonError salvar(EnderecoResource enderecoResource)
			throws EnderecoException {
		Endereco endereco = new Endereco();
		endereco = enderecoParser.paraDomain(enderecoResource, endereco);

		endereco.setListaContato(new ArrayList<Contato>());
		for (ContatoResource c : enderecoResource.getListaContatos()) {
			Contato contato = new Contato();
			contato = contatoParser.paraDomain(c, contato);
			endereco.getListaContato().add(contato);
		}
		Loja loja = lojaRepository.findOneByCodigo(enderecoResource.getLoja()
				.getCodigo());
		loja.setListaEndereco(new ArrayList<Endereco>());
		loja.getListaEndereco().add(endereco);
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(endereco);
		return objeto;
	}

	@Transactional
	public JsonError editar(EnderecoResource enderecoResource)
			throws EnderecoException {
		Endereco endereco = enderecoRepository.findOneByCodigo(enderecoResource
				.getCodigo());
		endereco = enderecoParser.paraDomain(enderecoResource, endereco);

		endereco.setListaContato(new ArrayList<Contato>());
		for (ContatoResource c : enderecoResource.getListaContatos()) {
			Contato contato = new Contato();
			contato = contatoParser.paraDomain(c, contato);
			endereco.getListaContato().add(contato);
		}
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(endereco);
		return objeto;
	}

	@Transactional
	public JsonError excluir(EnderecoResource enderecoResource)
			throws EnderecoException {
		Endereco endereco = enderecoRepository.findOneByCodigo(enderecoResource
				.getCodigo());
		enderecoRepository.delete(endereco);
		JsonError objeto = new JsonError();
		return objeto;
	}

	@Transactional
	public JsonError selecionar()throws EnderecoException{
		List<Endereco> listaEnderecos = (List<Endereco>) enderecoRepository.findAll();
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().addAll(listaEnderecos);
		return objeto;
	}
	
}
