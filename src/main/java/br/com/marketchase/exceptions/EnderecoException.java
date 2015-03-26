package br.com.marketchase.exceptions;

public class EnderecoException extends RuntimeException{

	public EnderecoException(){
		super();
	}
	
	public EnderecoException(String mensagem){
		super(mensagem);
	}
	
}
