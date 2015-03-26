package br.com.marketchase.parser;

import org.springframework.stereotype.Component;

import br.com.marketchase.models.domains.Contato;
import br.com.marketchase.models.resources.ContatoResource;

@Component
public class ContatoParser implements ObjectParser<Contato, ContatoResource> {

	@Override
	public Contato paraDomain(ContatoResource contatoResource, Contato contato) {
		contato.setCodigo(contatoResource.getCodigo());
		contato.setDescricao(contatoResource.getDescricao());
		contato.setTipoContato(contatoResource.getTipoContato());
		return contato;
	}

	@Override
	public ContatoResource paraResource(Contato contato, ContatoResource contatoResource) {
		contatoResource.setCodigo(contato.getCodigo());
		contatoResource.setDescricao(contato.getDescricao());
		contatoResource.setTipoContato(contato.getTipoContato());
		return contatoResource;
	}

}
