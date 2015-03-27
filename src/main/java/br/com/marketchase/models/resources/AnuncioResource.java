package br.com.marketchase.models.resources;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.marketchase.models.enums.AnuncioCategoria;
import br.com.marketchase.models.enums.AnuncioTipoArquivo;

public class AnuncioResource {
	
	private String descricao;
	
	@NotNull
	@NotEmpty
	private String caminhoArquivo;
	
	@NotNull
	@NotEmpty
	private String nomeArquivo;
	
	@NotNull
	@NotEmpty
	@Temporal(TemporalType.DATE)
	private Date dataPostagem;
	
	@NotNull
	@NotEmpty
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(columnDefinition = "true")
	private boolean permanente;
	
	@Column(columnDefinition = "true")
	private boolean ativo;
	
	@NotNull @NotEmpty
	@Enumerated(EnumType.STRING)
	private AnuncioTipoArquivo tipoArquivo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AnuncioCategoria categoria;
	
	@NotNull
	private long idLoja;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public boolean isPermanente() {
		return permanente;
	}

	public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public AnuncioTipoArquivo getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(AnuncioTipoArquivo tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public AnuncioCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(AnuncioCategoria categoria) {
		this.categoria = categoria;
	}

	public long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(long idLoja) {
		this.idLoja = idLoja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result
				+ ((caminhoArquivo == null) ? 0 : caminhoArquivo.hashCode());
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result
				+ ((dataPostagem == null) ? 0 : dataPostagem.hashCode());
		result = prime * result
				+ ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (idLoja ^ (idLoja >>> 32));
		result = prime * result
				+ ((nomeArquivo == null) ? 0 : nomeArquivo.hashCode());
		result = prime * result + (permanente ? 1231 : 1237);
		result = prime * result
				+ ((tipoArquivo == null) ? 0 : tipoArquivo.hashCode());
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
		AnuncioResource other = (AnuncioResource) obj;
		if (ativo != other.ativo)
			return false;
		if (caminhoArquivo == null) {
			if (other.caminhoArquivo != null)
				return false;
		} else if (!caminhoArquivo.equals(other.caminhoArquivo))
			return false;
		if (categoria != other.categoria)
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataPostagem == null) {
			if (other.dataPostagem != null)
				return false;
		} else if (!dataPostagem.equals(other.dataPostagem))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idLoja != other.idLoja)
			return false;
		if (nomeArquivo == null) {
			if (other.nomeArquivo != null)
				return false;
		} else if (!nomeArquivo.equals(other.nomeArquivo))
			return false;
		if (permanente != other.permanente)
			return false;
		if (tipoArquivo != other.tipoArquivo)
			return false;
		return true;
	}

}
