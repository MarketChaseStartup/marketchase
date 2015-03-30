package br.com.marketchase.parser;

import org.springframework.stereotype.Component;

import br.com.marketchase.models.domains.Anuncio;
import br.com.marketchase.models.resources.AnuncioResource;

@Component
public class AnuncioParser implements ObjectParser<Anuncio, AnuncioResource> {

	@Override
	public AnuncioResource paraResource(Anuncio anuncio, AnuncioResource anuncioResource) {
		anuncioResource.setDescricao(anuncio.getDescricao());
		anuncioResource.setCaminhoArquivo(anuncio.getCaminhoArquivo());
		anuncioResource.setNomeArquivo(anuncio.getNomeArquivo());
		anuncioResource.setDataPostagem(anuncio.getDataPostagem());
		anuncioResource.setDataHoraInicio(anuncio.getDataHoraInicio());
		anuncioResource.setDataHoraVencimento(anuncio.getDataHoraVencimento());
		anuncioResource.setPermanente(anuncio.isPermanente());
		anuncioResource.setAtivo(anuncio.isAtivo());
		anuncioResource.setTipoAnuncio(anuncio.getTipoAnuncio());
		anuncioResource.setCategoria(anuncio.getCategoria());
		return anuncioResource;
	}
	
	@Override
	public Anuncio paraDomain(AnuncioResource anuncioResource, Anuncio anuncio) {
		anuncio.setDescricao(anuncioResource.getDescricao());
		anuncio.setCaminhoArquivo(anuncioResource.getCaminhoArquivo());
		anuncio.setNomeArquivo(anuncioResource.getNomeArquivo());
		anuncio.setDataPostagem(anuncioResource.getDataPostagem());
		anuncio.setDataHoraInicio(anuncioResource.getDataHoraInicio());
		anuncio.setDataHoraVencimento(anuncioResource.getDataHoraVencimento());
		anuncio.setPermanente(anuncioResource.isPermanente());
		if (anuncioResource.getDataHoraInicio().after(anuncioResource.getDataPostagem())){
			anuncioResource.setAtivo(false);
		}
		anuncio.setTipoAnuncio(anuncioResource.getTipoAnuncio());
		anuncio.setCategoria(anuncioResource.getCategoria());
		return anuncio;
	}


}
