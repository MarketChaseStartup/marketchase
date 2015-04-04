package br.com.marketchase.models.resources;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.marketchase.enums.CategoriaAnuncio;
import br.com.marketchase.enums.TipoAnuncio;;

public class AnuncioResource {
	
	private long codigo;
	
	private String descricao;
	
	@NotNull
	@NotEmpty
	private String caminhoArquivo;
	
	@NotNull
	@NotEmpty
	private String nomeArquivo;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataPostagem;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraVencimento;
	
	@Column(columnDefinition = "true")
	private boolean permanente;
	
	@Column(columnDefinition = "true")
	private boolean ativo;
	
	@NotNull @NotEmpty
	@Enumerated(EnumType.STRING)
	private TipoAnuncio tipoAnuncio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaAnuncio categoria;
	
	@NotNull
	private LojaResource loja;
	

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

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraVencimento() {
		return dataHoraVencimento;
	}

	public void setDataHoraVencimento(Date dataHoraVencimento) {
		this.dataHoraVencimento = dataHoraVencimento;
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

	public TipoAnuncio getTipoAnuncio() {
		return tipoAnuncio;
	}

	public void setTipoAnuncio(TipoAnuncio tipoAnuncio) {
		this.tipoAnuncio = tipoAnuncio;
	}

	public CategoriaAnuncio getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaAnuncio categoria) {
		this.categoria = categoria;
	}

	public LojaResource getLoja() {
		return loja;
	}

	public void setLoja(LojaResource loja) {
		this.loja = loja;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
