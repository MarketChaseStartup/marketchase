package br.com.marketchase.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marketchase.exceptions.ContatoException;
import br.com.marketchase.models.domains.Contato;
import br.com.marketchase.models.domains.Endereco;
import br.com.marketchase.models.repositories.ContatoRepository;
import br.com.marketchase.models.repositories.EnderecoRepository;
import br.com.marketchase.models.resources.ContatoResource;
import br.com.marketchase.models.resources.JsonError;
import br.com.marketchase.parser.ContatoParser;
import br.com.marketchase.parser.EnderecoParser;
import br.com.marketchase.parser.LoginParser;
import br.com.marketchase.parser.LojaParser;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private LoginParser loginParser;

	@Autowired
	private LojaParser lojaParser;

	@Autowired
	private EnderecoParser enderecoParser;

	@Autowired
	private ContatoParser contatoParser;

	@Transactional
	public JsonError salvar(ContatoResource contatoResource)
			throws ContatoException {
		Contato contato = new Contato();
		contato = contatoParser.paraDomain(contatoResource, contato);
		Endereco endereco = enderecoRepository.findOneByCodigo(contatoResource
				.getEndereco().getCodigo());
		endereco.setListaContato(new ArrayList<Contato>());
		endereco.getListaContato().add(contato);
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(contato);
		return objeto;
	}

	@Transactional
	public JsonError editar(ContatoResource contatoResource)
			throws ContatoException {
		Contato contato = contatoRepository
				.findOneByCodigo(contatoResource.getCodigo());
		contato = contatoParser.paraDomain(contatoResource, contato);
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(contato);
		return objeto;
	}

	@Transactional
	public JsonError excluir(ContatoResource contatoResource)
			throws ContatoException {
		Contato contato = contatoRepository
				.findOne(contatoResource.getCodigo());
		contatoRepository.delete(contato);
		JsonError objeto = new JsonError();
		return objeto;
	}

	@Transactional
	public JsonError selecionar() throws ContatoException {
		List<Contato> listaContato = (List<Contato>) contatoRepository.findAll();
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().addAll(listaContato);
		return objeto;
	}

}
