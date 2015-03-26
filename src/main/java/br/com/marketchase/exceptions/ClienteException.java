package br.com.marketchase.exceptions;

public class ClienteException extends RuntimeException{

	public ClienteException(){
		super();
	}
	
	public ClienteException(String mensagem){
		super(mensagem);
	}
	
}
