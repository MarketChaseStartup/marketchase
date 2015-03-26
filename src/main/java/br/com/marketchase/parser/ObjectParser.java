package br.com.marketchase.parser;


public interface ObjectParser<T, Z>{
	public T paraDomain(Z entidadeZ, T entidadeT);
	public Z paraResource(T entidadeT, Z entidadeZ);
}