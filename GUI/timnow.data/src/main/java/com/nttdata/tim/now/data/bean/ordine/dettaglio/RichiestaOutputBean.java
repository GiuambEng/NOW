package com.nttdata.tim.now.data.bean.ordine.dettaglio;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RichiestaOutputBean implements Serializable {

	private static final long serialVersionUID = -1886096079950038427L;

	@JsonProperty("codiceOrdineOLO")
    private String codiceOrdineOLO;

    @JsonProperty("codificaOAO")
    private String codificaOAO;

    @JsonProperty("codiceOAO")
    private String codiceOAO;

    @JsonProperty("canale")
    private String canale;

    @JsonProperty("tipoLavorazione")
    private String tipoLavorazione;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataInvio")
    private Date dataInvio;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataInserimento")
    private Date dataInserimento;

	@JsonFormat(pattern = DateHelper.DATE_FE_LONG, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataAggiornamento")
    private Date dataAggiornamento;

    @JsonProperty("statoNow")
    private String statoNow;

    @JsonProperty("statoOao")
    private String statoOao;

    @JsonProperty("codiceCausaleNow")
    private String codiceCausaleNow;

    @JsonProperty("codiceCausaleOao")
    private String codiceCausaleOao;

    @JsonProperty("causaleOao")
    private String causaleOao;

    @JsonProperty("causaleNow")
    private String causaleNow;

    @JsonProperty("codiceOrdineOaoPadre")
    private String codiceOrdineOaoPadre;

    @JsonProperty("idRisorsa")
    private String idRisorsa;

    @JsonProperty("codiceProgetto")
    private String codiceProgetto;

    @JsonProperty("note")
    private String note;

    @JsonProperty("richiestaXML")
    private String richiestaXML;

    @JsonProperty("nomeFile")
    private String nomeFile;

	public String getCodiceOrdineOLO() {
		return codiceOrdineOLO;
	}

	public void setCodiceOrdineOLO(String codiceOrdineOLO) {
		this.codiceOrdineOLO = codiceOrdineOLO;
	}

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public String getCodiceOAO() {
		return codiceOAO;
	}

	public void setCodiceOAO(String codiceOAO) {
		this.codiceOAO = codiceOAO;
	}

	public String getCanale() {
		return canale;
	}

	public void setCanale(String canale) {
		this.canale = canale;
	}

	public String getTipoLavorazione() {
		return tipoLavorazione;
	}

	public void setTipoLavorazione(String tipoLavorazione) {
		this.tipoLavorazione = tipoLavorazione;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(Date dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public String getStatoNow() {
		return statoNow;
	}

	public void setStatoNow(String statoNow) {
		this.statoNow = statoNow;
	}

	public String getStatoOao() {
		return statoOao;
	}

	public void setStatoOao(String statoOao) {
		this.statoOao = statoOao;
	}

	public String getCodiceCausaleNow() {
		return codiceCausaleNow;
	}

	public void setCodiceCausaleNow(String codiceCausaleNow) {
		this.codiceCausaleNow = codiceCausaleNow;
	}

	public String getCodiceCausaleOao() {
		return codiceCausaleOao;
	}

	public void setCodiceCausaleOao(String codiceCausaleOao) {
		this.codiceCausaleOao = codiceCausaleOao;
	}

	public String getCausaleOao() {
		return causaleOao;
	}

	public void setCausaleOao(String causaleOao) {
		this.causaleOao = causaleOao;
	}

	public String getCausaleNow() {
		return causaleNow;
	}

	public void setCausaleNow(String causaleNow) {
		this.causaleNow = causaleNow;
	}

	public String getCodiceOrdineOaoPadre() {
		return codiceOrdineOaoPadre;
	}

	public void setCodiceOrdineOaoPadre(String codiceOrdineOaoPadre) {
		this.codiceOrdineOaoPadre = codiceOrdineOaoPadre;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getCodiceProgetto() {
		return codiceProgetto;
	}

	public void setCodiceProgetto(String codiceProgetto) {
		this.codiceProgetto = codiceProgetto;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRichiestaXML() {
		return richiestaXML;
	}

	public void setRichiestaXML(String richiestaXML) {
		this.richiestaXML = richiestaXML;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canale == null) ? 0 : canale.hashCode());
		result = prime * result + ((causaleNow == null) ? 0 : causaleNow.hashCode());
		result = prime * result + ((causaleOao == null) ? 0 : causaleOao.hashCode());
		result = prime * result + ((codiceCausaleNow == null) ? 0 : codiceCausaleNow.hashCode());
		result = prime * result + ((codiceCausaleOao == null) ? 0 : codiceCausaleOao.hashCode());
		result = prime * result + ((codiceOAO == null) ? 0 : codiceOAO.hashCode());
		result = prime * result + ((codiceOrdineOLO == null) ? 0 : codiceOrdineOLO.hashCode());
		result = prime * result + ((codiceOrdineOaoPadre == null) ? 0 : codiceOrdineOaoPadre.hashCode());
		result = prime * result + ((codiceProgetto == null) ? 0 : codiceProgetto.hashCode());
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((dataAggiornamento == null) ? 0 : dataAggiornamento.hashCode());
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((dataInvio == null) ? 0 : dataInvio.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((nomeFile == null) ? 0 : nomeFile.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((richiestaXML == null) ? 0 : richiestaXML.hashCode());
		result = prime * result + ((statoNow == null) ? 0 : statoNow.hashCode());
		result = prime * result + ((statoOao == null) ? 0 : statoOao.hashCode());
		result = prime * result + ((tipoLavorazione == null) ? 0 : tipoLavorazione.hashCode());
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
		RichiestaOutputBean other = (RichiestaOutputBean) obj;
		if (canale == null) {
			if (other.canale != null)
				return false;
		} else if (!canale.equals(other.canale))
			return false;
		if (causaleNow == null) {
			if (other.causaleNow != null)
				return false;
		} else if (!causaleNow.equals(other.causaleNow))
			return false;
		if (causaleOao == null) {
			if (other.causaleOao != null)
				return false;
		} else if (!causaleOao.equals(other.causaleOao))
			return false;
		if (codiceCausaleNow == null) {
			if (other.codiceCausaleNow != null)
				return false;
		} else if (!codiceCausaleNow.equals(other.codiceCausaleNow))
			return false;
		if (codiceCausaleOao == null) {
			if (other.codiceCausaleOao != null)
				return false;
		} else if (!codiceCausaleOao.equals(other.codiceCausaleOao))
			return false;
		if (codiceOAO == null) {
			if (other.codiceOAO != null)
				return false;
		} else if (!codiceOAO.equals(other.codiceOAO))
			return false;
		if (codiceOrdineOLO == null) {
			if (other.codiceOrdineOLO != null)
				return false;
		} else if (!codiceOrdineOLO.equals(other.codiceOrdineOLO))
			return false;
		if (codiceOrdineOaoPadre == null) {
			if (other.codiceOrdineOaoPadre != null)
				return false;
		} else if (!codiceOrdineOaoPadre.equals(other.codiceOrdineOaoPadre))
			return false;
		if (codiceProgetto == null) {
			if (other.codiceProgetto != null)
				return false;
		} else if (!codiceProgetto.equals(other.codiceProgetto))
			return false;
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
			return false;
		if (dataAggiornamento == null) {
			if (other.dataAggiornamento != null)
				return false;
		} else if (!dataAggiornamento.equals(other.dataAggiornamento))
			return false;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (dataInvio == null) {
			if (other.dataInvio != null)
				return false;
		} else if (!dataInvio.equals(other.dataInvio))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (nomeFile == null) {
			if (other.nomeFile != null)
				return false;
		} else if (!nomeFile.equals(other.nomeFile))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (richiestaXML == null) {
			if (other.richiestaXML != null)
				return false;
		} else if (!richiestaXML.equals(other.richiestaXML))
			return false;
		if (statoNow == null) {
			if (other.statoNow != null)
				return false;
		} else if (!statoNow.equals(other.statoNow))
			return false;
		if (statoOao == null) {
			if (other.statoOao != null)
				return false;
		} else if (!statoOao.equals(other.statoOao))
			return false;
		if (tipoLavorazione == null) {
			if (other.tipoLavorazione != null)
				return false;
		} else if (!tipoLavorazione.equals(other.tipoLavorazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RichiestaOutputBean [codiceOrdineOLO=" + codiceOrdineOLO + ", codificaOAO=" + codificaOAO
				+ ", codiceOAO=" + codiceOAO + ", canale=" + canale + ", tipoLavorazione=" + tipoLavorazione
				+ ", dataInvio=" + dataInvio + ", dataInserimento=" + dataInserimento + ", dataAggiornamento="
				+ dataAggiornamento + ", statoNow=" + statoNow + ", statoOao=" + statoOao + ", codiceCausaleNow="
				+ codiceCausaleNow + ", codiceCausaleOao=" + codiceCausaleOao + ", causaleOao=" + causaleOao
				+ ", causaleNow=" + causaleNow + ", codiceOrdineOaoPadre=" + codiceOrdineOaoPadre + ", idRisorsa="
				+ idRisorsa + ", codiceProgetto=" + codiceProgetto + ", note=" + note + ", richiestaXML=" + richiestaXML
				+ ", nomeFile=" + nomeFile + "]";
	}

	
}
