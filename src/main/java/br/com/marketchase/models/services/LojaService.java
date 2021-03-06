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
import br.com.marketchase.models.domains.Permissao;
import br.com.marketchase.models.repositories.LojaRepository;
import br.com.marketchase.models.repositories.PermissaoRepository;
import br.com.marketchase.models.resources.ContatoResource;
import br.com.marketchase.models.resources.EnderecoResource;
import br.com.marketchase.models.resources.JsonError;
import br.com.marketchase.models.resources.LoginResource;
import br.com.marketchase.models.resources.LojaResource;
import br.com.marketchase.parser.ContatoParser;
import br.com.marketchase.parser.EnderecoParser;
import br.com.marketchase.parser.LoginParser;
import br.com.marketchase.parser.LojaParser;

@Service
public class LojaService {

	private static final String ROLE_LOJISTA = "ROLE_LOJISTA";
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
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
		
		loja.setLogin(new Login());
		loja.setLogin(loginParser.paraDomain(lojaResource.getLogin(), loja.getLogin()));
		
		loja.getLogin().setListaPermissao(new ArrayList<Permissao>());
		loja.getLogin().getListaPermissao().add(permissaoRepository.findOneBynome(ROLE_LOJISTA));
		
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		for (EnderecoResource e : lojaResource.getListaEnderecos()) {
			Endereco endereco = new Endereco();
			endereco = enderecoParser.paraDomain(e, endereco);
			
			endereco.setListaContato(new ArrayList<Contato>());
			for (ContatoResource c : e.getListaContatos()) {
				Contato contato = new Contato();
				contato = contatoParser.paraDomain(c, contato);
				
				endereco.getListaContato().add(contato);
			}
			listaEndereco.add(endereco);
		}
		loja.setListaEndereco(listaEndereco);
		loja.getLogin().setLoja(loja);
		loja = lojaRepository.save(loja);
		
		lojaResource = null;
		lojaResource = new LojaResource();
		lojaResource.setLogin(new LoginResource());
		
		lojaResource = lojaParser.paraResource(loja, lojaResource);
		
		List<EnderecoResource> listaEnderecoResource = new ArrayList<EnderecoResource>();
		for (Endereco e : loja.getListaEndereco()){
			EnderecoResource enderecoResource = new EnderecoResource();
			enderecoResource = enderecoParser.paraResource(e, enderecoResource);
			
			enderecoResource.setListaContatos(new ArrayList<ContatoResource>());
			for(Contato c : e.getListaContato()){
				ContatoResource contatoResource = new ContatoResource();
				contatoResource = contatoParser.paraResource(c, contatoResource);
				enderecoResource.getListaContatos().add(contatoResource);
			}
			listaEnderecoResource.add(enderecoResource);
		}
		lojaResource.setListaEnderecos(new ArrayList<EnderecoResource>());
		lojaResource.getListaEnderecos().addAll(listaEnderecoResource);
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(lojaResource);
		return objeto;
	}

	@Transactional
	public JsonError alterar(LojaResource lojaResource) throws LojaException {
		Loja loja = new Loja();
		loja = lojaParser.paraDomain(lojaResource, loja);

		loja.setLogin(new Login());
		loja.setLogin(loginParser.paraDomain(lojaResource.getLogin(), loja.getLogin()));
		
		loja.getLogin().setListaPermissao(new ArrayList<Permissao>());
		loja.getLogin().getListaPermissao().add(permissaoRepository.findOneBynome(ROLE_LOJISTA));
		
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		for (EnderecoResource e : lojaResource.getListaEnderecos()) {
			Endereco endereco = new Endereco();
			endereco = enderecoParser.paraDomain(e, endereco);
			
			endereco.setListaContato(new ArrayList<Contato>());
			for (ContatoResource c : e.getListaContatos()) {
				Contato contato = new Contato();
				contato = contatoParser.paraDomain(c, contato);
				
				endereco.getListaContato().add(contato);
			}
			listaEndereco.add(endereco);
		}
		loja.setListaEndereco(listaEndereco);
		loja.getLogin().setLoja(loja);
		loja = lojaRepository.saveAndFlush(loja);

		lojaResource = null;
		lojaResource = new LojaResource();
		lojaResource.setLogin(new LoginResource());
		
		lojaResource = lojaParser.paraResource(loja, lojaResource);
		
		List<EnderecoResource> listaEnderecoResource = new ArrayList<EnderecoResource>();
		for (Endereco e : loja.getListaEndereco()){
			EnderecoResource enderecoResource = new EnderecoResource();
			enderecoResource = enderecoParser.paraResource(e, enderecoResource);
			
			enderecoResource.setListaContatos(new ArrayList<ContatoResource>());
			for(Contato c : e.getListaContato()){
				ContatoResource contatoResource = new ContatoResource();
				contatoResource = contatoParser.paraResource(c, contatoResource);
				enderecoResource.getListaContatos().add(contatoResource);
			}
			listaEnderecoResource.add(enderecoResource);
		}
		lojaResource.setListaEnderecos(new ArrayList<EnderecoResource>());
		lojaResource.getListaEnderecos().addAll(listaEnderecoResource);
		
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
			lojaResource.setListaEnderecos(new ArrayList<EnderecoResource>());
			lojaResource = lojaParser.paraResource(l, lojaResource);
			for (Endereco e : l.getListaEndereco()) {
				EnderecoResource enderecoResource = new EnderecoResource();
				enderecoResource.setListaContatos(new ArrayList<ContatoResource>());
				enderecoResource = enderecoParser.paraResource(e, enderecoResource);
				for(Contato c : e.getListaContato()){
					ContatoResource contatoResource = new ContatoResource();
					contatoResource = contatoParser.paraResource(c, contatoResource);
					enderecoResource.getListaContatos().add(contatoResource);
				}
				lojaResource.getListaEnderecos().add(enderecoResource);
			}
			listaLojasResource.add(lojaResource);
		}
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().addAll(listaLojasResource);
		return objeto;
	}
	
	public JsonError Selecionar(long codigo) throws LojaException{
		Loja loja = lojaRepository.findOne(codigo);
		
		LojaResource lojaResource = new LojaResource();
		lojaResource = lojaParser.paraResource(loja, lojaResource);
		
		lojaResource.setListaEnderecos(new ArrayList<EnderecoResource>());
		for (Endereco e : loja.getListaEndereco()) {
			EnderecoResource enderecoResource = new EnderecoResource();
			enderecoResource.setListaContatos(new ArrayList<ContatoResource>());
			enderecoResource = enderecoParser.paraResource(e, enderecoResource);
			for(Contato c : e.getListaContato()){
				ContatoResource contatoResource = new ContatoResource();
				contatoResource = contatoParser.paraResource(c, contatoResource);
				enderecoResource.getListaContatos().add(contatoResource);
			}
			lojaResource.getListaEnderecos().add(enderecoResource);
		}
		
		JsonError objeto = new JsonError();
		objeto.setListaObjetos(new ArrayList<Object>());
		objeto.getListaObjetos().add(lojaResource);
		return objeto;
	}
	
}
