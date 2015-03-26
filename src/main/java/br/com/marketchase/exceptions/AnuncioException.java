package br.com.marketchase.exceptions;

public class AnuncioException extends RuntimeException{

	public AnuncioException(){
		super();
	}
	
	public AnuncioException(String mensagem){
		super(mensagem);
	}
	
}
