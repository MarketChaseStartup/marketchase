package br.com.marketchase.exceptions;

public class ContatoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ContatoException(){
		super();
	}
	
	public ContatoException(String mensagem){
		super(mensagem);
	}
	
}
