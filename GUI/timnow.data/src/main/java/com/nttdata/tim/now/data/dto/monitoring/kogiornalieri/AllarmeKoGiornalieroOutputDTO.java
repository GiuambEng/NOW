package com.nttdata.tim.now.data.dto.monitoring.kogiornalieri;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AllarmeKoGiornalieroOutputDTO implements Serializable {

	private static final long serialVersionUID = 6697486622284702046L;

	@JsonProperty("codCausaleOlo")
	private String codCausaleOlo;

	@JsonProperty("causaleOlo")
	private String causaleOlo;

	@JsonProperty("ambito")
	private String ambito;

	@JsonProperty("totaleOdierno")
	private String totaleOdierno;

	@JsonProperty("media5ggLav")
	private String media5giorni;

	@JsonProperty("media30ggLav")
	private String media30giorni;

	@JsonProperty("soglia")
	private String soglia;

	public String getCausaleOlo() {
		return causaleOlo;
	}

	public void setCausaleOlo(String causaleOlo) {
		this.causaleOlo = causaleOlo;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getTotaleOdierno() {
		return totaleOdierno;
	}

	public void setTotaleOdierno(String totaleOdierno) {
		this.totaleOdierno = totaleOdierno;
	}

	public String getMedia5giorni() {
		return media5giorni;
	}

	public void setMedia5giorni(String media5giorni) {
		this.media5giorni = media5giorni;
	}

	public String getMedia30giorni() {
		return media30giorni;
	}

	public void setMedia30giorni(String media30giorni) {
		this.media30giorni = media30giorni;
	}

	public String getSoglia() {
		return soglia;
	}

	public void setSoglia(String soglia) {
		this.soglia = soglia;
	}

	public String getCodCausaleOlo() {
		return codCausaleOlo;
	}

	public void setCodCausaleOlo(String codCausaleOlo) {
		this.codCausaleOlo = codCausaleOlo;
	}

	@Override
	public String toString() {
		return "AllarmeDTO [codCausaleOlo=" + codCausaleOlo + ", causaleOlo=" + causaleOlo + ", ambito=" + ambito
				+ ", totaleOdierno=" + totaleOdierno + ", media5giorni=" + media5giorni + ", media30giorni="
				+ media30giorni + ", soglia=" + soglia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
		result = prime * result + ((causaleOlo == null) ? 0 : causaleOlo.hashCode());
		result = prime * result + ((codCausaleOlo == null) ? 0 : codCausaleOlo.hashCode());
		result = prime * result + ((media30giorni == null) ? 0 : media30giorni.hashCode());
		result = prime * result + ((media5giorni == null) ? 0 : media5giorni.hashCode());
		result = prime * result + ((soglia == null) ? 0 : soglia.hashCode());
		result = prime * result + ((totaleOdierno == null) ? 0 : totaleOdierno.hashCode());
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
		AllarmeKoGiornalieroOutputDTO other = (AllarmeKoGiornalieroOutputDTO) obj;
		if (ambito == null) {
			if (other.ambito != null)
				return false;
		} else if (!ambito.equals(other.ambito))
			return false;
		if (causaleOlo == null) {
			if (other.causaleOlo != null)
				return false;
		} else if (!causaleOlo.equals(other.causaleOlo))
			return false;
		if (codCausaleOlo == null) {
			if (other.codCausaleOlo != null)
				return false;
		} else if (!codCausaleOlo.equals(other.codCausaleOlo))
			return false;
		if (media30giorni == null) {
			if (other.media30giorni != null)
				return false;
		} else if (!media30giorni.equals(other.media30giorni))
			return false;
		if (media5giorni == null) {
			if (other.media5giorni != null)
				return false;
		} else if (!media5giorni.equals(other.media5giorni))
			return false;
		if (soglia == null) {
			if (other.soglia != null)
				return false;
		} else if (!soglia.equals(other.soglia))
			return false;
		if (totaleOdierno == null) {
			if (other.totaleOdierno != null)
				return false;
		} else if (!totaleOdierno.equals(other.totaleOdierno))
			return false;
		return true;
	}

}
