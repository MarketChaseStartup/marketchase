package br.com.marketchase.exceptions;

public class TipoContatoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TipoContatoException(){
		super();
	}
	
	public TipoContatoException(String mensagem){
		super(mensagem);
	}
	
}
