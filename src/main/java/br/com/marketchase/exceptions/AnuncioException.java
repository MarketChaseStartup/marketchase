package br.com.marketchase.exceptions;

public class AnuncioException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AnuncioException(){
		super();
	}
	
	public AnuncioException(String mensagem){
		super(mensagem);
	}
	
}
