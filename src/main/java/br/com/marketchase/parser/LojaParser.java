package br.com.marketchase.parser;

import org.springframework.stereotype.Component;

import br.com.marketchase.models.domains.Loja;
import br.com.marketchase.models.resources.LojaResource;

@Component
public class LojaParser implements ObjectParser<Loja, LojaResource>{

	@Override
	public LojaResource paraResource(Loja loja, LojaResource lojaResource) {
		lojaResource.setCodigo(loja.getCodigo());
		lojaResource.setNome(loja.getNome());
		lojaResource.setAtiva(loja.isAtiva());
		return lojaResource;
	}

	@Override
	public Loja paraDomain(LojaResource lojaResource, Loja loja) {
		loja.setCodigo(lojaResource.getCodigo());
		loja.setNome(lojaResource.getNome());
		loja.setAtiva(lojaResource.isAtiva());
		return loja;
	}	
	
}
