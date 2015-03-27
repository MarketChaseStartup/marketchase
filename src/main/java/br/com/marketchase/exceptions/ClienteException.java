package br.com.marketchase.exceptions;

public class ClienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ClienteException(){
		super();
	}
	
	public ClienteException(String mensagem){
		super(mensagem);
	}
	
}
