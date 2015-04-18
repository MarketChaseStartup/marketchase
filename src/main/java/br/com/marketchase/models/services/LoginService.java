package br.com.marketchase.models.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;

@Service
public class LoginService {
	
	private final static String SEPARADOR_CREDENCIAL = ":";
	
	public Map<String,String> prepareParameters(MultiValueMap<String, String> queryParameters) {
		Map<String,String> parameters = new HashMap<String,String>();
		Iterator<String> it = queryParameters.keySet().iterator();
		while(it.hasNext()){
			String theKey = (String)it.next();
		    parameters.put(theKey,queryParameters.getFirst(theKey));
		}

		return parameters;
	}
	
	public String decodificaCredenciais(String credencialBase64){
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes = null;
		try {
			decodedBytes = decoder.decodeBuffer(credencialBase64);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String credencialDecodificada = new String(decodedBytes);
		String nome = credencialDecodificada.substring(0, credencialDecodificada.indexOf(SEPARADOR_CREDENCIAL));
		return nome;
	}
	
}
