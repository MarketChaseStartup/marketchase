package br.com.marketchase.models.resources;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.marketchase.enums.TipoContato;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("contato")
public class ContatoResource {

	private long codigo;
	
	@NotNull
	@NotEmpty
	private String descricao;
	
	private TipoContato tipoContato;
	
	private ClienteResource cliente;
	
	private EnderecoResource endereco;
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public ClienteResource getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResource cliente) {
		this.cliente = cliente;
	}
	
	public EnderecoResource getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResource endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContatoResource other = (ContatoResource) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
}
