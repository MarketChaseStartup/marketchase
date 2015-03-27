package br.com.marketchase.exceptions;

public class TipoArquivoException extends RuntimeException{

	private static final long serialVersionUID = 5986432768282952371L;

	public TipoArquivoException(){
		super();
	}
	
	public TipoArquivoException(String mensagem){
		super(mensagem);
	}
	
}
