package br.com.marketchase.models.resources;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.hibernate.validator.constraints.NotEmpty;

public class ClienteResource{

	@XmlAttribute
	private long codigo;
	
	@NotNull
	@NotEmpty
	@XmlAttribute
	private String nome;

	@XmlAttribute
	@XmlElementWrapper(name = "contatos")
	@XmlElement(name = "contato")
	private List<ContatoResource> Contatos;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ClienteResource() {
		super();
	}

	public ClienteResource(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	
}
