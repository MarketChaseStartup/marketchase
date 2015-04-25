package br.com.marketchase.models.resources;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("json_error")
public class JsonError {

	@NotNull
	@NotEmpty
	private String mensagem;
	
	private List<Object> listaObjetos;
	
	@NotNull
	@NotEmpty
	private String status;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<Object> getListaObjetos() {
		return listaObjetos;
	}
	public void setListaObjetos(List<Object> listaOobjetos) {
		this.listaObjetos = listaOobjetos;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
