package br.com.marketchase.exceptions;

public class EnderecoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EnderecoException(){
		super();
	}
	
	public EnderecoException(String mensagem){
		super(mensagem);
	}
	
}
