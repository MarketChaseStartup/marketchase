package br.com.marketchase.models.resources;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.marketchase.enums.ZonaEndereco;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("endereco")
public class EnderecoResource {

	private long codigo;
	
	@NotNull
	@NotEmpty
	private String numero;
	
	@NotNull
	@NotEmpty
	private String complemento;
	
	@NotNull
	@NotEmpty
	private String rua;

	@NotNull
	@NotEmpty
	private String cep;
	
	@NotNull
	@NotEmpty	
	private String estado;
	
	@NotNull
	@NotEmpty	
	private String cidade;
	
	@NotNull
	@NotEmpty
	private String bairro;
	
	private String referencia;
	
	private ZonaEndereco zonaEndereco;
	
	private String tipoLogradouro;
	
	private List<ContatoResource> listaContatos;
	
	private LojaResource loja;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public List<ContatoResource> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<ContatoResource> listaContatos) {
		this.listaContatos = listaContatos;
	}

	public LojaResource getLoja() {
		return loja;
	}

	public void setLoja(LojaResource loja) {
		this.loja = loja;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public ZonaEndereco getZonaEndereco() {
		return zonaEndereco;
	}
	public void setZonaEndereco(ZonaEndereco zonaEndereco) {
		this.zonaEndereco = zonaEndereco;
	}
	
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		EnderecoResource other = (EnderecoResource) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
}
