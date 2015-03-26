package br.com.marketchase.exceptions;

public class TipoContatoException extends RuntimeException{

	public TipoContatoException(){
		super();
	}
	
	public TipoContatoException(String mensagem){
		super(mensagem);
	}
	
}
