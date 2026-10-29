package com.nttdata.tim.now.data.dto.monitoring.koolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoOloOutputDTO implements Serializable {

	private static final long serialVersionUID = 5853775481669739179L;

	@JsonProperty("CodiceCausaleOlo")
	private String codiceCausaleOlo;

	@JsonProperty("CodiceFamigliaCausale")
	private String codiceFamigliaCausale;

	@JsonProperty("Tot-DataEstrazione-1")
	private String estrazione2;

	@JsonProperty("Tot-DataEstrazione-2")
	private String estrazione3;

	@JsonProperty("Tot-DataEstrazione-3")
	private String estrazione4;

	@JsonProperty("Tot-DataEstrazione-4")
	private String estrazione5;

	@JsonProperty("Tot-DataEstrazione-5")
	private String estrazione6;

	@JsonProperty("Tot-DataEstrazione-6")
	private String estrazione7;

	@JsonProperty("Tot-TimestampAggRichOlo")
	private String estrazione1;

	@JsonProperty("TotaleComplessivo")
	private String totaleComplessivo;

	public String getCodiceCausaleOlo() {
		return codiceCausaleOlo;
	}

	public void setCodiceCausaleOlo(String codiceCausaleOlo) {
		this.codiceCausaleOlo = codiceCausaleOlo;
	}

	public String getCodiceFamigliaCausale() {
		return codiceFamigliaCausale;
	}

	public void setCodiceFamigliaCausale(String codiceFamigliaCausale) {
		this.codiceFamigliaCausale = codiceFamigliaCausale;
	}

	public String getEstrazione1() {
		return estrazione1;
	}

	public void setEstrazione1(String estrazione1) {
		this.estrazione1 = estrazione1;
	}

	public String getEstrazione2() {
		return estrazione2;
	}

	public void setEstrazione2(String estrazione2) {
		this.estrazione2 = estrazione2;
	}

	public String getEstrazione3() {
		return estrazione3;
	}

	public void setEstrazione3(String estrazione3) {
		this.estrazione3 = estrazione3;
	}

	public String getEstrazione4() {
		return estrazione4;
	}

	public void setEstrazione4(String estrazione4) {
		this.estrazione4 = estrazione4;
	}

	public String getEstrazione5() {
		return estrazione5;
	}

	public void setEstrazione5(String estrazione5) {
		this.estrazione5 = estrazione5;
	}

	public String getEstrazione6() {
		return estrazione6;
	}

	public void setEstrazione6(String estrazione6) {
		this.estrazione6 = estrazione6;
	}

	public String getEstrazione7() {
		return estrazione7;
	}

	public void setEstrazione7(String estrazione7) {
		this.estrazione7 = estrazione7;
	}

	public String getTotaleComplessivo() {
		return totaleComplessivo;
	}

	public void setTotaleComplessivo(String totaleComplessivo) {
		this.totaleComplessivo = totaleComplessivo;
	}

	@Override
	public String toString() {
		return "MonitoraggioKoOloDTO [codiceCausaleOlo=" + codiceCausaleOlo + ", codiceFamigliaCausale="
				+ codiceFamigliaCausale + ", estrazione1=" + estrazione1 + ", estrazione2=" + estrazione2
				+ ", estrazione3=" + estrazione3 + ", estrazione4=" + estrazione4 + ", estrazione5=" + estrazione5
				+ ", estrazione6=" + estrazione6 + ", estrazione7=" + estrazione7 + ", totaleComplessivo="
				+ totaleComplessivo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceCausaleOlo == null) ? 0 : codiceCausaleOlo.hashCode());
		result = prime * result + ((codiceFamigliaCausale == null) ? 0 : codiceFamigliaCausale.hashCode());
		result = prime * result + ((estrazione1 == null) ? 0 : estrazione1.hashCode());
		result = prime * result + ((estrazione2 == null) ? 0 : estrazione2.hashCode());
		result = prime * result + ((estrazione3 == null) ? 0 : estrazione3.hashCode());
		result = prime * result + ((estrazione4 == null) ? 0 : estrazione4.hashCode());
		result = prime * result + ((estrazione5 == null) ? 0 : estrazione5.hashCode());
		result = prime * result + ((estrazione6 == null) ? 0 : estrazione6.hashCode());
		result = prime * result + ((estrazione7 == null) ? 0 : estrazione7.hashCode());
		result = prime * result + ((totaleComplessivo == null) ? 0 : totaleComplessivo.hashCode());
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
		MonitoraggioKoOloOutputDTO other = (MonitoraggioKoOloOutputDTO) obj;
		if (codiceCausaleOlo == null) {
			if (other.codiceCausaleOlo != null)
				return false;
		} else if (!codiceCausaleOlo.equals(other.codiceCausaleOlo))
			return false;
		if (codiceFamigliaCausale == null) {
			if (other.codiceFamigliaCausale != null)
				return false;
		} else if (!codiceFamigliaCausale.equals(other.codiceFamigliaCausale))
			return false;
		if (estrazione1 == null) {
			if (other.estrazione1 != null)
				return false;
		} else if (!estrazione1.equals(other.estrazione1))
			return false;
		if (estrazione2 == null) {
			if (other.estrazione2 != null)
				return false;
		} else if (!estrazione2.equals(other.estrazione2))
			return false;
		if (estrazione3 == null) {
			if (other.estrazione3 != null)
				return false;
		} else if (!estrazione3.equals(other.estrazione3))
			return false;
		if (estrazione4 == null) {
			if (other.estrazione4 != null)
				return false;
		} else if (!estrazione4.equals(other.estrazione4))
			return false;
		if (estrazione5 == null) {
			if (other.estrazione5 != null)
				return false;
		} else if (!estrazione5.equals(other.estrazione5))
			return false;
		if (estrazione6 == null) {
			if (other.estrazione6 != null)
				return false;
		} else if (!estrazione6.equals(other.estrazione6))
			return false;
		if (estrazione7 == null) {
			if (other.estrazione7 != null)
				return false;
		} else if (!estrazione7.equals(other.estrazione7))
			return false;
		if (totaleComplessivo == null) {
			if (other.totaleComplessivo != null)
				return false;
		} else if (!totaleComplessivo.equals(other.totaleComplessivo))
			return false;
		return true;
	}

}
