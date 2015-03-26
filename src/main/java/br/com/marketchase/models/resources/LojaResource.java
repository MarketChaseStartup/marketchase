package br.com.marketchase.models.resources;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("loja")
public class LojaResource{
	
	private long codigo;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	private boolean ativa;
	
	private LoginResource login;
	
	private List<EnderecoResource> listaEnderecos;
	
	
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

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public LoginResource getLogin() {
		return login;
	}

	public void setLogin(LoginResource login) {
		this.login = login;
	}

	public List<EnderecoResource> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<EnderecoResource> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		LojaResource other = (LojaResource) obj;
		if (codigo != other.codigo)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	
	
}
