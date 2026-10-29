package com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class AggregatoDTO implements Serializable {

	private static final long serialVersionUID = 5111676788735196749L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DataEstrazione")
	private Date dataEstrazione;

	@JsonProperty("Ambito")
	private String ambito;

	@JsonProperty("Servizio")
	private String servizio;

	@JsonProperty("OrdinativiInSlaDtu")
	private String ordinativiInSlaDtu;

	@JsonProperty("PercOrdinativiInSlaDtu")
	private String percentualeOrdinativiInSlaDtu;

	@JsonProperty("OrdinativiFuoriSlaDtu")
	private String ordinativiFuoriSlaDtu;

	@JsonProperty("PercOrdinativiFuoriSlaDtu")
	private String percentualeOrdinativiFuoriSlaDtu;

	@JsonProperty("OrdinativiRimodulatiDtu")
	private String ordinativiRimodulatiDtu;

	@JsonProperty("PercOrdinativiRimodulatiDtu")
	private String percentualeOrdinativiRimodulatiDtu;

	@JsonProperty("OrdinativiInSlaNow")
	private String ordinativiInSlaNow;

	@JsonProperty("PercOrdinativiInSlaNow")
	private String percentualeOrdinativiInSlaNow;

	@JsonProperty("OrdinativiFuoriSlaNow")
	private String ordinativiFuoriSlaNow;

	@JsonProperty("PercOrdinativiFuoriSlaNow")
	private String percentualeOrdinativiFuoriSlaNow;

	@JsonProperty("OrdinativiRimodulatiNow")
	private String ordinativiRimodulatiNow;

	@JsonProperty("PercOrdinativiRimodulatiNow")
	private String percentualeOrdinativiRimodulatiNow;

	@JsonProperty("OrdinativiInSlaE2E")
	private String ordinativiInSlaE2E;

	@JsonProperty("PercOrdinativiInSlaE2E")
	private String percentualeOrdinativiInSlaE2E;

	@JsonProperty("OrdinativiFuoriSlaE2E")
	private String ordinativiFuoriSlaE2E;

	@JsonProperty("PercOrdinativiFuoriSlaE2E")
	private String percentualeOrdinativiFuoriSlaE2E;

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getOrdinativiInSlaDtu() {
		return ordinativiInSlaDtu;
	}

	public void setOrdinativiInSlaDtu(String ordinativiInSlaDtu) {
		this.ordinativiInSlaDtu = ordinativiInSlaDtu;
	}

	public String getPercentualeOrdinativiInSlaDtu() {
		return percentualeOrdinativiInSlaDtu;
	}

	public void setPercentualeOrdinativiInSlaDtu(String percentualeOrdinativiInSlaDtu) {
		this.percentualeOrdinativiInSlaDtu = percentualeOrdinativiInSlaDtu;
	}

	public String getOrdinativiFuoriSlaDtu() {
		return ordinativiFuoriSlaDtu;
	}

	public void setOrdinativiFuoriSlaDtu(String ordinativiFuoriSlaDtu) {
		this.ordinativiFuoriSlaDtu = ordinativiFuoriSlaDtu;
	}

	public String getPercentualeOrdinativiFuoriSlaDtu() {
		return percentualeOrdinativiFuoriSlaDtu;
	}

	public void setPercentualeOrdinativiFuoriSlaDtu(String percentualeOrdinativiFuoriSlaDtu) {
		this.percentualeOrdinativiFuoriSlaDtu = percentualeOrdinativiFuoriSlaDtu;
	}

	public String getOrdinativiRimodulatiDtu() {
		return ordinativiRimodulatiDtu;
	}

	public void setOrdinativiRimodulatiDtu(String ordinativiRimodulatiDtu) {
		this.ordinativiRimodulatiDtu = ordinativiRimodulatiDtu;
	}

	public String getPercentualeOrdinativiRimodulatiDtu() {
		return percentualeOrdinativiRimodulatiDtu;
	}

	public void setPercentualeOrdinativiRimodulatiDtu(String percentualeOrdinativiRimodulatiDtu) {
		this.percentualeOrdinativiRimodulatiDtu = percentualeOrdinativiRimodulatiDtu;
	}

	public String getOrdinativiInSlaNow() {
		return ordinativiInSlaNow;
	}

	public void setOrdinativiInSlaNow(String ordinativiInSlaNow) {
		this.ordinativiInSlaNow = ordinativiInSlaNow;
	}

	public String getPercentualeOrdinativiInSlaNow() {
		return percentualeOrdinativiInSlaNow;
	}

	public void setPercentualeOrdinativiInSlaNow(String percentualeOrdinativiInSlaNow) {
		this.percentualeOrdinativiInSlaNow = percentualeOrdinativiInSlaNow;
	}

	public String getOrdinativiFuoriSlaNow() {
		return ordinativiFuoriSlaNow;
	}

	public void setOrdinativiFuoriSlaNow(String ordinativiFuoriSlaNow) {
		this.ordinativiFuoriSlaNow = ordinativiFuoriSlaNow;
	}

	public String getPercentualeOrdinativiFuoriSlaNow() {
		return percentualeOrdinativiFuoriSlaNow;
	}

	public void setPercentualeOrdinativiFuoriSlaNow(String percentualeOrdinativiFuoriSlaNow) {
		this.percentualeOrdinativiFuoriSlaNow = percentualeOrdinativiFuoriSlaNow;
	}

	public String getOrdinativiRimodulatiNow() {
		return ordinativiRimodulatiNow;
	}

	public void setOrdinativiRimodulatiNow(String ordinativiRimodulatiNow) {
		this.ordinativiRimodulatiNow = ordinativiRimodulatiNow;
	}

	public String getPercentualeOrdinativiRimodulatiNow() {
		return percentualeOrdinativiRimodulatiNow;
	}

	public void setPercentualeOrdinativiRimodulatiNow(String percentualeOrdinativiRimodulatiNow) {
		this.percentualeOrdinativiRimodulatiNow = percentualeOrdinativiRimodulatiNow;
	}

	public String getOrdinativiInSlaE2E() {
		return ordinativiInSlaE2E;
	}

	public void setOrdinativiInSlaE2E(String ordinativiInSlaE2E) {
		this.ordinativiInSlaE2E = ordinativiInSlaE2E;
	}

	public String getPercentualeOrdinativiInSlaE2E() {
		return percentualeOrdinativiInSlaE2E;
	}

	public void setPercentualeOrdinativiInSlaE2E(String percentualeOrdinativiInSlaE2E) {
		this.percentualeOrdinativiInSlaE2E = percentualeOrdinativiInSlaE2E;
	}

	public String getOrdinativiFuoriSlaE2E() {
		return ordinativiFuoriSlaE2E;
	}

	public void setOrdinativiFuoriSlaE2E(String ordinativiFuoriSlaE2E) {
		this.ordinativiFuoriSlaE2E = ordinativiFuoriSlaE2E;
	}

	public String getPercentualeOrdinativiFuoriSlaE2E() {
		return percentualeOrdinativiFuoriSlaE2E;
	}

	public void setPercentualeOrdinativiFuoriSlaE2E(String percentualeOrdinativiFuoriSlaE2E) {
		this.percentualeOrdinativiFuoriSlaE2E = percentualeOrdinativiFuoriSlaE2E;
	}

	@Override
	public String toString() {
		return "AggregatoDTO [dataEstrazione=" + dataEstrazione + ", ambito=" + ambito + ", servizio=" + servizio
				+ ", ordinativiInSlaDtu=" + ordinativiInSlaDtu + ", percentualeOrdinativiInSlaDtu="
				+ percentualeOrdinativiInSlaDtu + ", ordinativiFuoriSlaDtu=" + ordinativiFuoriSlaDtu
				+ ", percentualeOrdinativiFuoriSlaDtu=" + percentualeOrdinativiFuoriSlaDtu
				+ ", ordinativiRimodulatiDtu=" + ordinativiRimodulatiDtu + ", percentualeOrdinativiRimodulatiDtu="
				+ percentualeOrdinativiRimodulatiDtu + ", ordinativiInSlaNow=" + ordinativiInSlaNow
				+ ", percentualeOrdinativiInSlaNow=" + percentualeOrdinativiInSlaNow + ", ordinativiFuoriSlaNow="
				+ ordinativiFuoriSlaNow + ", percentualeOrdinativiFuoriSlaNow=" + percentualeOrdinativiFuoriSlaNow
				+ ", ordinativiRimodulatiNow=" + ordinativiRimodulatiNow + ", percentualeOrdinativiRimodulatiNow="
				+ percentualeOrdinativiRimodulatiNow + ", ordinativiInSlaE2E=" + ordinativiInSlaE2E
				+ ", percentualeOrdinativiInSlaE2E=" + percentualeOrdinativiInSlaE2E + ", ordinativiFuoriSlaE2E="
				+ ordinativiFuoriSlaE2E + ", percentualeOrdinativiFuoriSlaE2E=" + percentualeOrdinativiFuoriSlaE2E
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
		result = prime * result + ((dataEstrazione == null) ? 0 : dataEstrazione.hashCode());
		result = prime * result + ((ordinativiFuoriSlaDtu == null) ? 0 : ordinativiFuoriSlaDtu.hashCode());
		result = prime * result + ((ordinativiFuoriSlaE2E == null) ? 0 : ordinativiFuoriSlaE2E.hashCode());
		result = prime * result + ((ordinativiFuoriSlaNow == null) ? 0 : ordinativiFuoriSlaNow.hashCode());
		result = prime * result + ((ordinativiInSlaDtu == null) ? 0 : ordinativiInSlaDtu.hashCode());
		result = prime * result + ((ordinativiInSlaE2E == null) ? 0 : ordinativiInSlaE2E.hashCode());
		result = prime * result + ((ordinativiInSlaNow == null) ? 0 : ordinativiInSlaNow.hashCode());
		result = prime * result + ((ordinativiRimodulatiDtu == null) ? 0 : ordinativiRimodulatiDtu.hashCode());
		result = prime * result + ((ordinativiRimodulatiNow == null) ? 0 : ordinativiRimodulatiNow.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiFuoriSlaDtu == null) ? 0 : percentualeOrdinativiFuoriSlaDtu.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiFuoriSlaE2E == null) ? 0 : percentualeOrdinativiFuoriSlaE2E.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiFuoriSlaNow == null) ? 0 : percentualeOrdinativiFuoriSlaNow.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiInSlaDtu == null) ? 0 : percentualeOrdinativiInSlaDtu.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiInSlaE2E == null) ? 0 : percentualeOrdinativiInSlaE2E.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiInSlaNow == null) ? 0 : percentualeOrdinativiInSlaNow.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiRimodulatiDtu == null) ? 0 : percentualeOrdinativiRimodulatiDtu.hashCode());
		result = prime * result
				+ ((percentualeOrdinativiRimodulatiNow == null) ? 0 : percentualeOrdinativiRimodulatiNow.hashCode());
		result = prime * result + ((servizio == null) ? 0 : servizio.hashCode());
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
		AggregatoDTO other = (AggregatoDTO) obj;
		if (ambito == null) {
			if (other.ambito != null)
				return false;
		} else if (!ambito.equals(other.ambito))
			return false;
		if (dataEstrazione == null) {
			if (other.dataEstrazione != null)
				return false;
		} else if (!dataEstrazione.equals(other.dataEstrazione))
			return false;
		if (ordinativiFuoriSlaDtu == null) {
			if (other.ordinativiFuoriSlaDtu != null)
				return false;
		} else if (!ordinativiFuoriSlaDtu.equals(other.ordinativiFuoriSlaDtu))
			return false;
		if (ordinativiFuoriSlaE2E == null) {
			if (other.ordinativiFuoriSlaE2E != null)
				return false;
		} else if (!ordinativiFuoriSlaE2E.equals(other.ordinativiFuoriSlaE2E))
			return false;
		if (ordinativiFuoriSlaNow == null) {
			if (other.ordinativiFuoriSlaNow != null)
				return false;
		} else if (!ordinativiFuoriSlaNow.equals(other.ordinativiFuoriSlaNow))
			return false;
		if (ordinativiInSlaDtu == null) {
			if (other.ordinativiInSlaDtu != null)
				return false;
		} else if (!ordinativiInSlaDtu.equals(other.ordinativiInSlaDtu))
			return false;
		if (ordinativiInSlaE2E == null) {
			if (other.ordinativiInSlaE2E != null)
				return false;
		} else if (!ordinativiInSlaE2E.equals(other.ordinativiInSlaE2E))
			return false;
		if (ordinativiInSlaNow == null) {
			if (other.ordinativiInSlaNow != null)
				return false;
		} else if (!ordinativiInSlaNow.equals(other.ordinativiInSlaNow))
			return false;
		if (ordinativiRimodulatiDtu == null) {
			if (other.ordinativiRimodulatiDtu != null)
				return false;
		} else if (!ordinativiRimodulatiDtu.equals(other.ordinativiRimodulatiDtu))
			return false;
		if (ordinativiRimodulatiNow == null) {
			if (other.ordinativiRimodulatiNow != null)
				return false;
		} else if (!ordinativiRimodulatiNow.equals(other.ordinativiRimodulatiNow))
			return false;
		if (percentualeOrdinativiFuoriSlaDtu == null) {
			if (other.percentualeOrdinativiFuoriSlaDtu != null)
				return false;
		} else if (!percentualeOrdinativiFuoriSlaDtu.equals(other.percentualeOrdinativiFuoriSlaDtu))
			return false;
		if (percentualeOrdinativiFuoriSlaE2E == null) {
			if (other.percentualeOrdinativiFuoriSlaE2E != null)
				return false;
		} else if (!percentualeOrdinativiFuoriSlaE2E.equals(other.percentualeOrdinativiFuoriSlaE2E))
			return false;
		if (percentualeOrdinativiFuoriSlaNow == null) {
			if (other.percentualeOrdinativiFuoriSlaNow != null)
				return false;
		} else if (!percentualeOrdinativiFuoriSlaNow.equals(other.percentualeOrdinativiFuoriSlaNow))
			return false;
		if (percentualeOrdinativiInSlaDtu == null) {
			if (other.percentualeOrdinativiInSlaDtu != null)
				return false;
		} else if (!percentualeOrdinativiInSlaDtu.equals(other.percentualeOrdinativiInSlaDtu))
			return false;
		if (percentualeOrdinativiInSlaE2E == null) {
			if (other.percentualeOrdinativiInSlaE2E != null)
				return false;
		} else if (!percentualeOrdinativiInSlaE2E.equals(other.percentualeOrdinativiInSlaE2E))
			return false;
		if (percentualeOrdinativiInSlaNow == null) {
			if (other.percentualeOrdinativiInSlaNow != null)
				return false;
		} else if (!percentualeOrdinativiInSlaNow.equals(other.percentualeOrdinativiInSlaNow))
			return false;
		if (percentualeOrdinativiRimodulatiDtu == null) {
			if (other.percentualeOrdinativiRimodulatiDtu != null)
				return false;
		} else if (!percentualeOrdinativiRimodulatiDtu.equals(other.percentualeOrdinativiRimodulatiDtu))
			return false;
		if (percentualeOrdinativiRimodulatiNow == null) {
			if (other.percentualeOrdinativiRimodulatiNow != null)
				return false;
		} else if (!percentualeOrdinativiRimodulatiNow.equals(other.percentualeOrdinativiRimodulatiNow))
			return false;
		if (servizio == null) {
			if (other.servizio != null)
				return false;
		} else if (!servizio.equals(other.servizio))
			return false;
		return true;
	}

}
