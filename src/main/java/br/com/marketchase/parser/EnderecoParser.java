package br.com.marketchase.parser;

import org.springframework.stereotype.Component;

import br.com.marketchase.models.domains.Endereco;
import br.com.marketchase.models.resources.EnderecoResource;
import br.com.marketchase.parser.ObjectParser;

@Component
public class EnderecoParser implements ObjectParser<Endereco, EnderecoResource> {

	@Override
	public Endereco paraDomain(EnderecoResource enderecoResource, Endereco endereco) {
		endereco.setCodigo(enderecoResource.getCodigo());
		endereco.setNumero(enderecoResource.getNumero());
		endereco.setComplemento(enderecoResource.getComplemento());
		endereco.setRua(enderecoResource.getRua());
		endereco.setCep(enderecoResource.getCep());
		endereco.setEstado(enderecoResource.getEstado());
		endereco.setCidade(enderecoResource.getCidade());
		endereco.setBairro(enderecoResource.getBairro());
		endereco.setReferencia(enderecoResource.getReferencia());
		endereco.setZonaEndereco(enderecoResource.getZonaEndereco());
		return endereco;
	}

	@Override
	public EnderecoResource paraResource(Endereco endereco, EnderecoResource enderecoResource) {
		enderecoResource.setCodigo(endereco.getCodigo());
		enderecoResource.setCep(endereco.getCep());
		enderecoResource.setComplemento(endereco.getComplemento());
		enderecoResource.setNumero(endereco.getNumero());
		enderecoResource.setRua(endereco.getRua());
		enderecoResource.setCidade(endereco.getCidade());
		enderecoResource.setEstado(endereco.getEstado());
		enderecoResource.setBairro(endereco.getBairro());
		enderecoResource.setReferencia(endereco.getReferencia());
		enderecoResource.setZonaEndereco(endereco.getZonaEndereco());
		return enderecoResource;
	}

}
