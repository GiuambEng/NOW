
package com.nttdata.tim.now.data.bean.monitoring.agcom;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioAgcomT5Bean extends AbstractOutputBean {

	private static final long serialVersionUID = 236155849852621631L;

	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataRif")
	private Date dataRif;
	
	@JsonProperty("nonRealizzabiliDAC_LA_LAV_NR")
	private String nonRealizzabiliDacLaLavNr;
	
	@JsonProperty("nonRealizzabiliDAC_LA_NR")
	private String nonRealizzabiliDacLaNr;
	
	@JsonProperty("nonRealizzabiliDAC_LA_PERC")
	private String nonRealizzabiliDacLaPerc;
	
	@JsonProperty("nonRealizzabiliDAC_LNA_LAV_NR")
	private String nonRealizzabiliDacLnaLavNr;
	
	@JsonProperty("nonRealizzabiliDAC_LNA_NR")
	private String nonRealizzabiliDacLnaNr;
	
	@JsonProperty("nonRealizzabiliDAC_LNA_PERC")
	private String nonRealizzabiliDacLnaPerc;
	
	@JsonProperty("nonRealizzabiliSLA_LAeLNA_LAV_NR")
	private String nonRealizzabiliSlaLaELnaLavNr;
	
	@JsonProperty("nonRealizzabiliSLA_LAeLNA_NR")
	private String nonRealizzabiliSlaLaELnaNr;
	
	@JsonProperty("nonRealizzabiliSLA_LAeLNA_PERC")
	private String nonRealizzabiliSlaLaELnaPerc;
	
	@JsonProperty("tipo")
	private String tipo;

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	public String getNonRealizzabiliDacLaLavNr() {
		return nonRealizzabiliDacLaLavNr;
	}

	public void setNonRealizzabiliDacLaLavNr(String nonRealizzabiliDacLaLavNr) {
		this.nonRealizzabiliDacLaLavNr = nonRealizzabiliDacLaLavNr;
	}

	public String getNonRealizzabiliDacLaNr() {
		return nonRealizzabiliDacLaNr;
	}

	public void setNonRealizzabiliDacLaNr(String nonRealizzabiliDacLaNr) {
		this.nonRealizzabiliDacLaNr = nonRealizzabiliDacLaNr;
	}

	public String getNonRealizzabiliDacLaPerc() {
		return nonRealizzabiliDacLaPerc;
	}

	public void setNonRealizzabiliDacLaPerc(String nonRealizzabiliDacLaPerc) {
		this.nonRealizzabiliDacLaPerc = nonRealizzabiliDacLaPerc;
	}

	public String getNonRealizzabiliDacLnaLavNr() {
		return nonRealizzabiliDacLnaLavNr;
	}

	public void setNonRealizzabiliDacLnaLavNr(String nonRealizzabiliDacLnaLavNr) {
		this.nonRealizzabiliDacLnaLavNr = nonRealizzabiliDacLnaLavNr;
	}

	public String getNonRealizzabiliDacLnaNr() {
		return nonRealizzabiliDacLnaNr;
	}

	public void setNonRealizzabiliDacLnaNr(String nonRealizzabiliDacLnaNr) {
		this.nonRealizzabiliDacLnaNr = nonRealizzabiliDacLnaNr;
	}

	public String getNonRealizzabiliDacLnaPerc() {
		return nonRealizzabiliDacLnaPerc;
	}

	public void setNonRealizzabiliDacLnaPerc(String nonRealizzabiliDacLnaPerc) {
		this.nonRealizzabiliDacLnaPerc = nonRealizzabiliDacLnaPerc;
	}

	public String getNonRealizzabiliSlaLaELnaLavNr() {
		return nonRealizzabiliSlaLaELnaLavNr;
	}

	public void setNonRealizzabiliSlaLaELnaLavNr(String nonRealizzabiliSlaLaELnaLavNr) {
		this.nonRealizzabiliSlaLaELnaLavNr = nonRealizzabiliSlaLaELnaLavNr;
	}

	public String getNonRealizzabiliSlaLaELnaNr() {
		return nonRealizzabiliSlaLaELnaNr;
	}

	public void setNonRealizzabiliSlaLaELnaNr(String nonRealizzabiliSlaLaELnaNr) {
		this.nonRealizzabiliSlaLaELnaNr = nonRealizzabiliSlaLaELnaNr;
	}

	public String getNonRealizzabiliSlaLaELnaPerc() {
		return nonRealizzabiliSlaLaELnaPerc;
	}

	public void setNonRealizzabiliSlaLaELnaPerc(String nonRealizzabiliSlaLaELnaPerc) {
		this.nonRealizzabiliSlaLaELnaPerc = nonRealizzabiliSlaLaELnaPerc;
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
		result = prime * result + ((dataRif == null) ? 0 : dataRif.hashCode());
		result = prime * result + ((nonRealizzabiliDacLaLavNr == null) ? 0 : nonRealizzabiliDacLaLavNr.hashCode());
		result = prime * result + ((nonRealizzabiliDacLaNr == null) ? 0 : nonRealizzabiliDacLaNr.hashCode());
		result = prime * result + ((nonRealizzabiliDacLaPerc == null) ? 0 : nonRealizzabiliDacLaPerc.hashCode());
		result = prime * result + ((nonRealizzabiliDacLnaLavNr == null) ? 0 : nonRealizzabiliDacLnaLavNr.hashCode());
		result = prime * result + ((nonRealizzabiliDacLnaNr == null) ? 0 : nonRealizzabiliDacLnaNr.hashCode());
		result = prime * result + ((nonRealizzabiliDacLnaPerc == null) ? 0 : nonRealizzabiliDacLnaPerc.hashCode());
		result = prime * result
				+ ((nonRealizzabiliSlaLaELnaLavNr == null) ? 0 : nonRealizzabiliSlaLaELnaLavNr.hashCode());
		result = prime * result + ((nonRealizzabiliSlaLaELnaNr == null) ? 0 : nonRealizzabiliSlaLaELnaNr.hashCode());
		result = prime * result
				+ ((nonRealizzabiliSlaLaELnaPerc == null) ? 0 : nonRealizzabiliSlaLaELnaPerc.hashCode());
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
		MonitoraggioAgcomT5Bean other = (MonitoraggioAgcomT5Bean) obj;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (nonRealizzabiliDacLaLavNr == null) {
			if (other.nonRealizzabiliDacLaLavNr != null)
				return false;
		} else if (!nonRealizzabiliDacLaLavNr.equals(other.nonRealizzabiliDacLaLavNr))
			return false;
		if (nonRealizzabiliDacLaNr == null) {
			if (other.nonRealizzabiliDacLaNr != null)
				return false;
		} else if (!nonRealizzabiliDacLaNr.equals(other.nonRealizzabiliDacLaNr))
			return false;
		if (nonRealizzabiliDacLaPerc == null) {
			if (other.nonRealizzabiliDacLaPerc != null)
				return false;
		} else if (!nonRealizzabiliDacLaPerc.equals(other.nonRealizzabiliDacLaPerc))
			return false;
		if (nonRealizzabiliDacLnaLavNr == null) {
			if (other.nonRealizzabiliDacLnaLavNr != null)
				return false;
		} else if (!nonRealizzabiliDacLnaLavNr.equals(other.nonRealizzabiliDacLnaLavNr))
			return false;
		if (nonRealizzabiliDacLnaNr == null) {
			if (other.nonRealizzabiliDacLnaNr != null)
				return false;
		} else if (!nonRealizzabiliDacLnaNr.equals(other.nonRealizzabiliDacLnaNr))
			return false;
		if (nonRealizzabiliDacLnaPerc == null) {
			if (other.nonRealizzabiliDacLnaPerc != null)
				return false;
		} else if (!nonRealizzabiliDacLnaPerc.equals(other.nonRealizzabiliDacLnaPerc))
			return false;
		if (nonRealizzabiliSlaLaELnaLavNr == null) {
			if (other.nonRealizzabiliSlaLaELnaLavNr != null)
				return false;
		} else if (!nonRealizzabiliSlaLaELnaLavNr.equals(other.nonRealizzabiliSlaLaELnaLavNr))
			return false;
		if (nonRealizzabiliSlaLaELnaNr == null) {
			if (other.nonRealizzabiliSlaLaELnaNr != null)
				return false;
		} else if (!nonRealizzabiliSlaLaELnaNr.equals(other.nonRealizzabiliSlaLaELnaNr))
			return false;
		if (nonRealizzabiliSlaLaELnaPerc == null) {
			if (other.nonRealizzabiliSlaLaELnaPerc != null)
				return false;
		} else if (!nonRealizzabiliSlaLaELnaPerc.equals(other.nonRealizzabiliSlaLaELnaPerc))
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
		return "MonitoraggioAgcomT5Bean [dataRif=" + dataRif + ", nonRealizzabiliDacLaLavNr="
				+ nonRealizzabiliDacLaLavNr + ", nonRealizzabiliDacLaNr=" + nonRealizzabiliDacLaNr
				+ ", nonRealizzabiliDacLaPerc=" + nonRealizzabiliDacLaPerc + ", nonRealizzabiliDacLnaLavNr="
				+ nonRealizzabiliDacLnaLavNr + ", nonRealizzabiliDacLnaNr=" + nonRealizzabiliDacLnaNr
				+ ", nonRealizzabiliDacLnaPerc=" + nonRealizzabiliDacLnaPerc + ", nonRealizzabiliSlaLaELnaLavNr="
				+ nonRealizzabiliSlaLaELnaLavNr + ", nonRealizzabiliSlaLaELnaNr=" + nonRealizzabiliSlaLaELnaNr
				+ ", nonRealizzabiliSlaLaELnaPerc=" + nonRealizzabiliSlaLaELnaPerc + ", tipo=" + tipo + "]";
	}

}
