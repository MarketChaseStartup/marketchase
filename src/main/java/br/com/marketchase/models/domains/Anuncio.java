package br.com.marketchase.models.domains;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.marketchase.enums.TipoAnuncio;
import br.com.marketchase.models.enums.AnuncioCategoria;
import br.com.marketchase.models.enums.AnuncioTipoArquivo;

@Entity
@Table(name = "anuncios")
@Audited
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@NotNull
	@NotEmpty
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

	@NotNull
	@NotEmpty
	@Temporal(TemporalType.TIME)
	private Date horaInicio;

	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Temporal(TemporalType.TIME)
	private Date horaVemcimento;

	private boolean permanente;

	private boolean ativo;

	@Enumerated(EnumType.STRING)
	private TipoAnuncio tipoAnuncio;

	@Enumerated(EnumType.STRING)
	private AnuncioCategoria categoria;
	
	@Enumerated(EnumType.STRING)
	private AnuncioTipoArquivo tipoArquivo;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(nullable=false)
	private Loja loja;
	
	public Anuncio() {

	}

	public Anuncio(long codigo, String descricao, String caminhoArquivo,
			String nomeArquivo, Date dataPostagem, Date dataInicio,
			Date horaInicio, Date dataVencimento, Date horaVemcimento,
			boolean permanente, boolean ativo, TipoAnuncio tipoAnuncio) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.caminhoArquivo = caminhoArquivo;
		this.nomeArquivo = nomeArquivo;
		this.dataPostagem = dataPostagem;
		this.dataInicio = dataInicio;
		this.horaInicio = horaInicio;
		this.dataVencimento = dataVencimento;
		this.horaVemcimento = horaVemcimento;
		this.permanente = permanente;
		this.ativo = ativo;
		this.tipoAnuncio = tipoAnuncio;
	}

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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getHoraVemcimento() {
		return horaVemcimento;
	}

	public void setHoraVemcimento(Date horaVemcimento) {
		this.horaVemcimento = horaVemcimento;
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

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public void setTipoAnuncio(TipoAnuncio tipoAnuncio) {
		this.tipoAnuncio = tipoAnuncio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((caminhoArquivo == null) ? 0 : caminhoArquivo.hashCode());
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
		Anuncio other = (Anuncio) obj;
		if (caminhoArquivo == null) {
			if (other.caminhoArquivo != null)
				return false;
		} else if (!caminhoArquivo.equals(other.caminhoArquivo))
			return false;
		return true;
	}

	
	
}
