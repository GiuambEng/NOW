package com.nttdata.tim.now.data.dto.asset;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RicaricaOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -6511467961395781666L;

	@JsonProperty("codificaOAO")
	private String codificaOAO;

	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataInizioRicarica")
	private Date dataInizioRicarica;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataFineRicarica")
	private Date dataFineRicarica;

	@JsonProperty("stato")
	private String stato;

	@JsonProperty("tipologiaAccensioneRicarica")
	private String tipologiaAccensioneRicarica;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("ultimoAggiornamento")
	private Date ultimoAggiornamento;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("idRicarica")
	private String idRicarica;

	@JsonProperty("taglioRicaricaInGiorni")
	private String taglioRicaricaInGiorni;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataInserimentoRichiesta")
	private Date dataInserimentoRichiesta;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataAnnullamento")
	private Date dataAnnullamento;

	@JsonProperty("statoAssetDinamico")
	private String statoAssetDinamico;

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public Date getDataInizioRicarica() {
		return dataInizioRicarica;
	}

	public void setDataInizioRicarica(Date dataInizioRicarica) {
		this.dataInizioRicarica = dataInizioRicarica;
	}

	public Date getDataFineRicarica() {
		return dataFineRicarica;
	}

	public void setDataFineRicarica(Date dataFineRicarica) {
		this.dataFineRicarica = dataFineRicarica;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTipologiaAccensioneRicarica() {
		return tipologiaAccensioneRicarica;
	}

	public void setTipologiaAccensioneRicarica(String tipologiaAccensioneRicarica) {
		this.tipologiaAccensioneRicarica = tipologiaAccensioneRicarica;
	}

	public Date getUltimoAggiornamento() {
		return ultimoAggiornamento;
	}

	public void setUltimoAggiornamento(Date ultimoAggiornamento) {
		this.ultimoAggiornamento = ultimoAggiornamento;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdRicarica() {
		return idRicarica;
	}

	public void setIdRicarica(String idRicarica) {
		this.idRicarica = idRicarica;
	}

	public String getTaglioRicaricaInGiorni() {
		return taglioRicaricaInGiorni;
	}

	public void setTaglioRicaricaInGiorni(String taglioRicaricaInGiorni) {
		this.taglioRicaricaInGiorni = taglioRicaricaInGiorni;
	}

	public Date getDataInserimentoRichiesta() {
		return dataInserimentoRichiesta;
	}

	public void setDataInserimentoRichiesta(Date dataInserimentoRichiesta) {
		this.dataInserimentoRichiesta = dataInserimentoRichiesta;
	}

	public Date getDataAnnullamento() {
		return dataAnnullamento;
	}

	public void setDataAnnullamento(Date dataAnnullamento) {
		this.dataAnnullamento = dataAnnullamento;
	}

	public String getStatoAssetDinamico() {
		return statoAssetDinamico;
	}

	public void setStatoAssetDinamico(String statoAssetDinamico) {
		this.statoAssetDinamico = statoAssetDinamico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((dataAnnullamento == null) ? 0 : dataAnnullamento.hashCode());
		result = prime * result + ((dataFineRicarica == null) ? 0 : dataFineRicarica.hashCode());
		result = prime * result + ((dataInizioRicarica == null) ? 0 : dataInizioRicarica.hashCode());
		result = prime * result + ((dataInserimentoRichiesta == null) ? 0 : dataInserimentoRichiesta.hashCode());
		result = prime * result + ((idRicarica == null) ? 0 : idRicarica.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((statoAssetDinamico == null) ? 0 : statoAssetDinamico.hashCode());
		result = prime * result + ((taglioRicaricaInGiorni == null) ? 0 : taglioRicaricaInGiorni.hashCode());
		result = prime * result + ((tipologiaAccensioneRicarica == null) ? 0 : tipologiaAccensioneRicarica.hashCode());
		result = prime * result + ((ultimoAggiornamento == null) ? 0 : ultimoAggiornamento.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		RicaricaOutputDTO other = (RicaricaOutputDTO) obj;
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
			return false;
		if (dataAnnullamento == null) {
			if (other.dataAnnullamento != null)
				return false;
		} else if (!dataAnnullamento.equals(other.dataAnnullamento))
			return false;
		if (dataFineRicarica == null) {
			if (other.dataFineRicarica != null)
				return false;
		} else if (!dataFineRicarica.equals(other.dataFineRicarica))
			return false;
		if (dataInizioRicarica == null) {
			if (other.dataInizioRicarica != null)
				return false;
		} else if (!dataInizioRicarica.equals(other.dataInizioRicarica))
			return false;
		if (dataInserimentoRichiesta == null) {
			if (other.dataInserimentoRichiesta != null)
				return false;
		} else if (!dataInserimentoRichiesta.equals(other.dataInserimentoRichiesta))
			return false;
		if (idRicarica == null) {
			if (other.idRicarica != null)
				return false;
		} else if (!idRicarica.equals(other.idRicarica))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (statoAssetDinamico == null) {
			if (other.statoAssetDinamico != null)
				return false;
		} else if (!statoAssetDinamico.equals(other.statoAssetDinamico))
			return false;
		if (taglioRicaricaInGiorni == null) {
			if (other.taglioRicaricaInGiorni != null)
				return false;
		} else if (!taglioRicaricaInGiorni.equals(other.taglioRicaricaInGiorni))
			return false;
		if (tipologiaAccensioneRicarica == null) {
			if (other.tipologiaAccensioneRicarica != null)
				return false;
		} else if (!tipologiaAccensioneRicarica.equals(other.tipologiaAccensioneRicarica))
			return false;
		if (ultimoAggiornamento == null) {
			if (other.ultimoAggiornamento != null)
				return false;
		} else if (!ultimoAggiornamento.equals(other.ultimoAggiornamento))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RicaricaOutputDTO [codificaOAO=" + codificaOAO + ", idRisorsa=" + idRisorsa + ", dataInizioRicarica="
				+ dataInizioRicarica + ", dataFineRicarica=" + dataFineRicarica + ", stato=" + stato
				+ ", tipologiaAccensioneRicarica=" + tipologiaAccensioneRicarica + ", ultimoAggiornamento="
				+ ultimoAggiornamento + ", userId=" + userId + ", idRicarica=" + idRicarica
				+ ", taglioRicaricaInGiorni=" + taglioRicaricaInGiorni + ", dataInserimentoRichiesta="
				+ dataInserimentoRichiesta + ", dataAnnullamento=" + dataAnnullamento + ", statoAssetDinamico="
				+ statoAssetDinamico + "]";
	}

	
}
