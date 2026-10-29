
package com.nttdata.tim.now.data.bean.monitoring.fatturazione;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneContatoreOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 8233027494056339126L;

	@JsonProperty("dataEstrazione")
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	private Date dataEstrazione;

	@JsonProperty("dataRicezioneOrdine")
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	private Date dataRicezioneOrdine;

	@JsonProperty("statoOrdineNOW")
	private String statoOrdineNOW;

	@JsonProperty("statoRichiestaOLO")
	private String statoRichiestaOLO;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("codificaOloNOW")
	private String codificaOloNow;

	@JsonProperty("tipologiaLavorazione")
	private String tipologiaLavorazione;

	@JsonProperty("servizio")
	private String servizio;

	@JsonProperty("codiceOrdineOlo")
	private String codiceOrdineOlo;

	@JsonProperty("idRichiesta")
	private String idRichiesta;

	@JsonProperty("codiceOrdineTI")
	private String codiceOrdineTI;

	@JsonProperty("famigliaOfferta")
	private String famigliaOfferta;

	@JsonProperty("idEventoOrdineNOW")
	private String idEventoOrdineNow;

	@JsonProperty("dataEvento")
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	private Date dataEvento;

	@JsonProperty("causaleScarto")
	private String causaleScarto;

	@JsonProperty("descCausaleScarto")
	private String descrizioneCausaleScarto;

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public Date getDataRicezioneOrdine() {
		return dataRicezioneOrdine;
	}

	public void setDataRicezioneOrdine(Date dataRicezioneOrdine) {
		this.dataRicezioneOrdine = dataRicezioneOrdine;
	}

	public String getStatoOrdineNOW() {
		return statoOrdineNOW;
	}

	public void setStatoOrdineNOW(String statoOrdineNOW) {
		this.statoOrdineNOW = statoOrdineNOW;
	}

	public String getStatoRichiestaOLO() {
		return statoRichiestaOLO;
	}

	public void setStatoRichiestaOLO(String statoRichiestaOLO) {
		this.statoRichiestaOLO = statoRichiestaOLO;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodificaOloNow() {
		return codificaOloNow;
	}

	public void setCodificaOloNow(String codificaOloNow) {
		this.codificaOloNow = codificaOloNow;
	}

	public String getTipologiaLavorazione() {
		return tipologiaLavorazione;
	}

	public void setTipologiaLavorazione(String tipologiaLavorazione) {
		this.tipologiaLavorazione = tipologiaLavorazione;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getCodiceOrdineOlo() {
		return codiceOrdineOlo;
	}

	public void setCodiceOrdineOlo(String codiceOrdineOlo) {
		this.codiceOrdineOlo = codiceOrdineOlo;
	}

	public String getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public String getFamigliaOfferta() {
		return famigliaOfferta;
	}

	public void setFamigliaOfferta(String famigliaOfferta) {
		this.famigliaOfferta = famigliaOfferta;
	}

	public String getIdEventoOrdineNow() {
		return idEventoOrdineNow;
	}

	public void setIdEventoOrdineNow(String idEventoOrdineNow) {
		this.idEventoOrdineNow = idEventoOrdineNow;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getCausaleScarto() {
		return causaleScarto;
	}

	public void setCausaleScarto(String causaleScarto) {
		this.causaleScarto = causaleScarto;
	}

	public String getDescrizioneCausaleScarto() {
		return descrizioneCausaleScarto;
	}

	public void setDescrizioneCausaleScarto(String descrizioneCausaleScarto) {
		this.descrizioneCausaleScarto = descrizioneCausaleScarto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causaleScarto == null) ? 0 : causaleScarto.hashCode());
		result = prime * result + ((codiceOrdineOlo == null) ? 0 : codiceOrdineOlo.hashCode());
		result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((codificaOloNow == null) ? 0 : codificaOloNow.hashCode());
		result = prime * result + ((dataEstrazione == null) ? 0 : dataEstrazione.hashCode());
		result = prime * result + ((dataEvento == null) ? 0 : dataEvento.hashCode());
		result = prime * result + ((dataRicezioneOrdine == null) ? 0 : dataRicezioneOrdine.hashCode());
		result = prime * result + ((descrizioneCausaleScarto == null) ? 0 : descrizioneCausaleScarto.hashCode());
		result = prime * result + ((famigliaOfferta == null) ? 0 : famigliaOfferta.hashCode());
		result = prime * result + ((idEventoOrdineNow == null) ? 0 : idEventoOrdineNow.hashCode());
		result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
		result = prime * result + ((servizio == null) ? 0 : servizio.hashCode());
		result = prime * result + ((statoOrdineNOW == null) ? 0 : statoOrdineNOW.hashCode());
		result = prime * result + ((statoRichiestaOLO == null) ? 0 : statoRichiestaOLO.hashCode());
		result = prime * result + ((tipologiaLavorazione == null) ? 0 : tipologiaLavorazione.hashCode());
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
		MonitoraggioFatturazioneContatoreOutputBean other = (MonitoraggioFatturazioneContatoreOutputBean) obj;
		if (causaleScarto == null) {
			if (other.causaleScarto != null)
				return false;
		} else if (!causaleScarto.equals(other.causaleScarto))
			return false;
		if (codiceOrdineOlo == null) {
			if (other.codiceOrdineOlo != null)
				return false;
		} else if (!codiceOrdineOlo.equals(other.codiceOrdineOlo))
			return false;
		if (codiceOrdineTI == null) {
			if (other.codiceOrdineTI != null)
				return false;
		} else if (!codiceOrdineTI.equals(other.codiceOrdineTI))
			return false;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (codificaOloNow == null) {
			if (other.codificaOloNow != null)
				return false;
		} else if (!codificaOloNow.equals(other.codificaOloNow))
			return false;
		if (dataEstrazione == null) {
			if (other.dataEstrazione != null)
				return false;
		} else if (!dataEstrazione.equals(other.dataEstrazione))
			return false;
		if (dataEvento == null) {
			if (other.dataEvento != null)
				return false;
		} else if (!dataEvento.equals(other.dataEvento))
			return false;
		if (dataRicezioneOrdine == null) {
			if (other.dataRicezioneOrdine != null)
				return false;
		} else if (!dataRicezioneOrdine.equals(other.dataRicezioneOrdine))
			return false;
		if (descrizioneCausaleScarto == null) {
			if (other.descrizioneCausaleScarto != null)
				return false;
		} else if (!descrizioneCausaleScarto.equals(other.descrizioneCausaleScarto))
			return false;
		if (famigliaOfferta == null) {
			if (other.famigliaOfferta != null)
				return false;
		} else if (!famigliaOfferta.equals(other.famigliaOfferta))
			return false;
		if (idEventoOrdineNow == null) {
			if (other.idEventoOrdineNow != null)
				return false;
		} else if (!idEventoOrdineNow.equals(other.idEventoOrdineNow))
			return false;
		if (idRichiesta == null) {
			if (other.idRichiesta != null)
				return false;
		} else if (!idRichiesta.equals(other.idRichiesta))
			return false;
		if (servizio == null) {
			if (other.servizio != null)
				return false;
		} else if (!servizio.equals(other.servizio))
			return false;
		if (statoOrdineNOW == null) {
			if (other.statoOrdineNOW != null)
				return false;
		} else if (!statoOrdineNOW.equals(other.statoOrdineNOW))
			return false;
		if (statoRichiestaOLO == null) {
			if (other.statoRichiestaOLO != null)
				return false;
		} else if (!statoRichiestaOLO.equals(other.statoRichiestaOLO))
			return false;
		if (tipologiaLavorazione == null) {
			if (other.tipologiaLavorazione != null)
				return false;
		} else if (!tipologiaLavorazione.equals(other.tipologiaLavorazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneContatoreOutputBean [dataEstrazione=" + dataEstrazione
				+ ", dataRicezioneOrdine=" + dataRicezioneOrdine + ", statoOrdineNOW=" + statoOrdineNOW
				+ ", statoRichiestaOLO=" + statoRichiestaOLO + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", codificaOloNow=" + codificaOloNow + ", tipologiaLavorazione=" + tipologiaLavorazione
				+ ", servizio=" + servizio + ", codiceOrdineOlo=" + codiceOrdineOlo + ", idRichiesta=" + idRichiesta
				+ ", codiceOrdineTI=" + codiceOrdineTI + ", famigliaOfferta=" + famigliaOfferta + ", idEventoOrdineNow="
				+ idEventoOrdineNow + ", dataEvento=" + dataEvento + ", causaleScarto=" + causaleScarto
				+ ", descrizioneCausaleScarto=" + descrizioneCausaleScarto + "]";
	}

}
