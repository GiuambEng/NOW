package com.nttdata.tim.now.data.dto.monitoring.agcom;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioAgcomT4DTO implements Serializable {

	private static final long serialVersionUID = 3328643894320417481L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataRif")
	private Date dataRif;
	
	@JsonProperty("rimodulazioniCausaTI_LA_GIAC")
	private String rimodulazioniCausaTiLaGiac;
	
	@JsonProperty("rimodulazioniCausaTI_LA_RIM")
	private String rimodulazioniCausaTiLaRim;
	
	@JsonProperty("rimodulazioniCausaTI_LA_PERC")
	private String rimodulazioniCausaTiLaPerc;
	
	@JsonProperty("rimodulazioniCausaTI_LNA_GIAC")
	private String rimodulazioniCausaTiLnaGiac;
	
	@JsonProperty("rimodulazioniCausaTI_LNA_RIM")
	private String rimodulazioniCausaTiLnaRim;
	
	@JsonProperty("rimodulazioniCausaTI_LNA_PERC")
	private String rimodulazioniCausaTiLnaPerc;
	
	@JsonProperty("rimodulazioniCausaTI_TOT_GIAC")
	private String rimodulazioniCausaTiTotGiac;
	
	@JsonProperty("rimodulazioniCausaTI_TOT_RIM")
	private String rimodulazioniCausaTiTotRim;
	
	@JsonProperty("rimodulazioniCausaTI_TOT_PERC")
	private String rimodulazioniCausaTiTotPerc;
	
	@JsonProperty("tipo")
	private String tipo;

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	public String getRimodulazioniCausaTiLaGiac() {
		return rimodulazioniCausaTiLaGiac;
	}

	public void setRimodulazioniCausaTiLaGiac(String rimodulazioniCausaTiLaGiac) {
		this.rimodulazioniCausaTiLaGiac = rimodulazioniCausaTiLaGiac;
	}

	public String getRimodulazioniCausaTiLaRim() {
		return rimodulazioniCausaTiLaRim;
	}

	public void setRimodulazioniCausaTiLaRim(String rimodulazioniCausaTiLaRim) {
		this.rimodulazioniCausaTiLaRim = rimodulazioniCausaTiLaRim;
	}

	public String getRimodulazioniCausaTiLaPerc() {
		return rimodulazioniCausaTiLaPerc;
	}

	public void setRimodulazioniCausaTiLaPerc(String rimodulazioniCausaTiLaPerc) {
		this.rimodulazioniCausaTiLaPerc = rimodulazioniCausaTiLaPerc;
	}

	public String getRimodulazioniCausaTiLnaGiac() {
		return rimodulazioniCausaTiLnaGiac;
	}

	public void setRimodulazioniCausaTiLnaGiac(String rimodulazioniCausaTiLnaGiac) {
		this.rimodulazioniCausaTiLnaGiac = rimodulazioniCausaTiLnaGiac;
	}

	public String getRimodulazioniCausaTiLnaRim() {
		return rimodulazioniCausaTiLnaRim;
	}

	public void setRimodulazioniCausaTiLnaRim(String rimodulazioniCausaTiLnaRim) {
		this.rimodulazioniCausaTiLnaRim = rimodulazioniCausaTiLnaRim;
	}

	public String getRimodulazioniCausaTiLnaPerc() {
		return rimodulazioniCausaTiLnaPerc;
	}

	public void setRimodulazioniCausaTiLnaPerc(String rimodulazioniCausaTiLnaPerc) {
		this.rimodulazioniCausaTiLnaPerc = rimodulazioniCausaTiLnaPerc;
	}

	public String getRimodulazioniCausaTiTotGiac() {
		return rimodulazioniCausaTiTotGiac;
	}

	public void setRimodulazioniCausaTiTotGiac(String rimodulazioniCausaTiTotGiac) {
		this.rimodulazioniCausaTiTotGiac = rimodulazioniCausaTiTotGiac;
	}

	public String getRimodulazioniCausaTiTotRim() {
		return rimodulazioniCausaTiTotRim;
	}

	public void setRimodulazioniCausaTiTotRim(String rimodulazioniCausaTiTotRim) {
		this.rimodulazioniCausaTiTotRim = rimodulazioniCausaTiTotRim;
	}

	public String getRimodulazioniCausaTiTotPerc() {
		return rimodulazioniCausaTiTotPerc;
	}

	public void setRimodulazioniCausaTiTotPerc(String rimodulazioniCausaTiTotPerc) {
		this.rimodulazioniCausaTiTotPerc = rimodulazioniCausaTiTotPerc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rimodulazioniCausaTiLaGiac == null) ? 0 : rimodulazioniCausaTiLaGiac.hashCode());
		result = prime * result + ((rimodulazioniCausaTiLaPerc == null) ? 0 : rimodulazioniCausaTiLaPerc.hashCode());
		result = prime * result + ((rimodulazioniCausaTiLaRim == null) ? 0 : rimodulazioniCausaTiLaRim.hashCode());
		result = prime * result + ((rimodulazioniCausaTiLnaGiac == null) ? 0 : rimodulazioniCausaTiLnaGiac.hashCode());
		result = prime * result + ((rimodulazioniCausaTiLnaPerc == null) ? 0 : rimodulazioniCausaTiLnaPerc.hashCode());
		result = prime * result + ((rimodulazioniCausaTiLnaRim == null) ? 0 : rimodulazioniCausaTiLnaRim.hashCode());
		result = prime * result + ((rimodulazioniCausaTiTotGiac == null) ? 0 : rimodulazioniCausaTiTotGiac.hashCode());
		result = prime * result + ((rimodulazioniCausaTiTotPerc == null) ? 0 : rimodulazioniCausaTiTotPerc.hashCode());
		result = prime * result + ((rimodulazioniCausaTiTotRim == null) ? 0 : rimodulazioniCausaTiTotRim.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		MonitoraggioAgcomT4DTO other = (MonitoraggioAgcomT4DTO) obj;
		if (rimodulazioniCausaTiLaGiac == null) {
			if (other.rimodulazioniCausaTiLaGiac != null)
				return false;
		} else if (!rimodulazioniCausaTiLaGiac.equals(other.rimodulazioniCausaTiLaGiac))
			return false;
		if (rimodulazioniCausaTiLaPerc == null) {
			if (other.rimodulazioniCausaTiLaPerc != null)
				return false;
		} else if (!rimodulazioniCausaTiLaPerc.equals(other.rimodulazioniCausaTiLaPerc))
			return false;
		if (rimodulazioniCausaTiLaRim == null) {
			if (other.rimodulazioniCausaTiLaRim != null)
				return false;
		} else if (!rimodulazioniCausaTiLaRim.equals(other.rimodulazioniCausaTiLaRim))
			return false;
		if (rimodulazioniCausaTiLnaGiac == null) {
			if (other.rimodulazioniCausaTiLnaGiac != null)
				return false;
		} else if (!rimodulazioniCausaTiLnaGiac.equals(other.rimodulazioniCausaTiLnaGiac))
			return false;
		if (rimodulazioniCausaTiLnaPerc == null) {
			if (other.rimodulazioniCausaTiLnaPerc != null)
				return false;
		} else if (!rimodulazioniCausaTiLnaPerc.equals(other.rimodulazioniCausaTiLnaPerc))
			return false;
		if (rimodulazioniCausaTiLnaRim == null) {
			if (other.rimodulazioniCausaTiLnaRim != null)
				return false;
		} else if (!rimodulazioniCausaTiLnaRim.equals(other.rimodulazioniCausaTiLnaRim))
			return false;
		if (rimodulazioniCausaTiTotGiac == null) {
			if (other.rimodulazioniCausaTiTotGiac != null)
				return false;
		} else if (!rimodulazioniCausaTiTotGiac.equals(other.rimodulazioniCausaTiTotGiac))
			return false;
		if (rimodulazioniCausaTiTotPerc == null) {
			if (other.rimodulazioniCausaTiTotPerc != null)
				return false;
		} else if (!rimodulazioniCausaTiTotPerc.equals(other.rimodulazioniCausaTiTotPerc))
			return false;
		if (rimodulazioniCausaTiTotRim == null) {
			if (other.rimodulazioniCausaTiTotRim != null)
				return false;
		} else if (!rimodulazioniCausaTiTotRim.equals(other.rimodulazioniCausaTiTotRim))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonitoraggioAgcomT4DTO [rimodulazioniCausaTiLaGiac=" + rimodulazioniCausaTiLaGiac
				+ ", rimodulazioniCausaTiLaRim=" + rimodulazioniCausaTiLaRim + ", rimodulazioniCausaTiLaPerc="
				+ rimodulazioniCausaTiLaPerc + ", rimodulazioniCausaTiLnaGiac=" + rimodulazioniCausaTiLnaGiac
				+ ", rimodulazioniCausaTiLnaRim=" + rimodulazioniCausaTiLnaRim + ", rimodulazioniCausaTiLnaPerc="
				+ rimodulazioniCausaTiLnaPerc + ", rimodulazioniCausaTiTotGiac=" + rimodulazioniCausaTiTotGiac
				+ ", rimodulazioniCausaTiTotRim=" + rimodulazioniCausaTiTotRim + ", rimodulazioniCausaTiTotPerc="
				+ rimodulazioniCausaTiTotPerc + ", tipo=" + tipo + "]";
	}

}
