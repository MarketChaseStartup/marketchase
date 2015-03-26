package br.com.marketchase.models.resources;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonTypeName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml_error")
@JsonTypeName("json_error")
public class JsonError {

	@NotNull
	@NotEmpty
	@XmlAttribute
	private String mensagem;
	
	@XmlAttribute
	private List<Object> listaObjetos;
	
	@NotNull
	@NotEmpty
	@XmlAttribute
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
