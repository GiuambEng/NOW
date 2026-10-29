package com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RichiesteMonitoraggioRigenerazioneMailOutputBean implements Serializable {

    private static final long serialVersionUID = -5833146207351438525L;

	@JsonFormat(pattern = DateHelper.DATE_FE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataInvio")
	private Date dataInvio;

	@JsonProperty("codiceOrdineOao")
	private String codiceOrdineOao;

	@JsonProperty("ordineTI")
	private String ordineTI;

	@JsonProperty("tipoLavorazione")
	private String tipoLavorazione;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("statoNow")
	private String statoNow;
	
	@JsonProperty("statoOao")
	private String statoOao;

	@JsonProperty("codificaOao")
	private String codificaOao;

	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getCodiceOrdineOao() {
		return codiceOrdineOao;
	}

	public void setCodiceOrdineOao(String codiceOrdineOao) {
		this.codiceOrdineOao = codiceOrdineOao;
	}

	public String getOrdineTI() {
		return ordineTI;
	}

	public void setOrdineTI(String ordineTI) {
		this.ordineTI = ordineTI;
	}

	public String getTipoLavorazione() {
		return tipoLavorazione;
	}

	public void setTipoLavorazione(String tipoLavorazione) {
		this.tipoLavorazione = tipoLavorazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
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

	public String getCodificaOao() {
		return codificaOao;
	}

	public void setCodificaOao(String codificaOao) {
		this.codificaOao = codificaOao;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOrdineOao == null) ? 0 : codiceOrdineOao.hashCode());
		result = prime * result + ((codificaOao == null) ? 0 : codificaOao.hashCode());
		result = prime * result + ((dataInvio == null) ? 0 : dataInvio.hashCode());
		result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((ordineTI == null) ? 0 : ordineTI.hashCode());
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
		RichiesteMonitoraggioRigenerazioneMailOutputBean other = (RichiesteMonitoraggioRigenerazioneMailOutputBean) obj;
		if (codiceOrdineOao == null) {
			if (other.codiceOrdineOao != null)
				return false;
		} else if (!codiceOrdineOao.equals(other.codiceOrdineOao))
			return false;
		if (codificaOao == null) {
			if (other.codificaOao != null)
				return false;
		} else if (!codificaOao.equals(other.codificaOao))
			return false;
		if (dataInvio == null) {
			if (other.dataInvio != null)
				return false;
		} else if (!dataInvio.equals(other.dataInvio))
			return false;
		if (idRichiestaOlo == null) {
			if (other.idRichiestaOlo != null)
				return false;
		} else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (ordineTI == null) {
			if (other.ordineTI != null)
				return false;
		} else if (!ordineTI.equals(other.ordineTI))
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
		return "RichiesteMonitoraggioRigenerazioneMailOutputBean [dataInvio=" + dataInvio + ", codiceOrdineOao="
				+ codiceOrdineOao + ", ordineTI=" + ordineTI + ", tipoLavorazione=" + tipoLavorazione + ", offerta="
				+ offerta + ", statoNow=" + statoNow + ", statoOao=" + statoOao + ", codificaOao=" + codificaOao
				+ ", idRichiestaOlo=" + idRichiestaOlo + "]";
	}



}