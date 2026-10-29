package com.nttdata.tim.now.data.dto.monitoring.warning;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioMonitoraggioKoWarningOutputDTO implements Serializable {

	private static final long serialVersionUID = -8144504858167142128L;

	@JsonProperty("lavorazione")
	private String lavorazione;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataEstrazione")
	private Date dataEstrazione;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("descrizioneCausaleOrdineOlo")
	private String descrizioneCausaleOrdineOlo;

	@JsonProperty("causaleOrdineOlo")
	private String causaleOrdineOlo;

	@JsonProperty("totale")
	private String totale;

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getDescrizioneCausaleOrdineOlo() {
		return descrizioneCausaleOrdineOlo;
	}

	public void setDescrizioneCausaleOrdineOlo(String descrizioneCausaleOrdineOlo) {
		this.descrizioneCausaleOrdineOlo = descrizioneCausaleOrdineOlo;
	}

	public String getCausaleOrdineOlo() {
		return causaleOrdineOlo;
	}

	public void setCausaleOrdineOlo(String causaleOrdineOlo) {
		this.causaleOrdineOlo = causaleOrdineOlo;
	}

	public String getTotale() {
		return totale;
	}

	public void setTotale(String totale) {
		this.totale = totale;
	}

	@Override
	public String toString() {
		return "DettaglioMonitoraggioKoWarningDTO [lavorazione=" + lavorazione + ", dataEstrazione=" + dataEstrazione
				+ ", offerta=" + offerta + ", descrizioneCausaleOrdineOlo=" + descrizioneCausaleOrdineOlo
				+ ", causaleOrdineOlo=" + causaleOrdineOlo + ", totale=" + totale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causaleOrdineOlo == null) ? 0 : causaleOrdineOlo.hashCode());
		result = prime * result + ((dataEstrazione == null) ? 0 : dataEstrazione.hashCode());
		result = prime * result + ((descrizioneCausaleOrdineOlo == null) ? 0 : descrizioneCausaleOrdineOlo.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((totale == null) ? 0 : totale.hashCode());
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
		DettaglioMonitoraggioKoWarningOutputDTO other = (DettaglioMonitoraggioKoWarningOutputDTO) obj;
		if (causaleOrdineOlo == null) {
			if (other.causaleOrdineOlo != null)
				return false;
		} else if (!causaleOrdineOlo.equals(other.causaleOrdineOlo))
			return false;
		if (dataEstrazione == null) {
			if (other.dataEstrazione != null)
				return false;
		} else if (!dataEstrazione.equals(other.dataEstrazione))
			return false;
		if (descrizioneCausaleOrdineOlo == null) {
			if (other.descrizioneCausaleOrdineOlo != null)
				return false;
		} else if (!descrizioneCausaleOrdineOlo.equals(other.descrizioneCausaleOrdineOlo))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (totale == null) {
			if (other.totale != null)
				return false;
		} else if (!totale.equals(other.totale))
			return false;
		return true;
	}

}
