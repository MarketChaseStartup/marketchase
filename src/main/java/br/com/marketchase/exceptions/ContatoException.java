package br.com.marketchase.exceptions;

public class ContatoException extends RuntimeException{

	public ContatoException(){
		super();
	}
	
	public ContatoException(String mensagem){
		super(mensagem);
	}
	
}
