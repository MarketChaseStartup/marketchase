package br.com.marketchase.exceptions;

public class TipoArquivoException extends RuntimeException{

	public TipoArquivoException(){
		super();
	}
	
	public TipoArquivoException(String mensagem){
		super(mensagem);
	}
	
}
