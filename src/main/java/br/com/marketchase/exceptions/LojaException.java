package br.com.marketchase.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class LojaException extends RuntimeException{

	public LojaException(){
		super();
	}
	
	public LojaException(String mensagem){
		super(mensagem);
	}
	
}
