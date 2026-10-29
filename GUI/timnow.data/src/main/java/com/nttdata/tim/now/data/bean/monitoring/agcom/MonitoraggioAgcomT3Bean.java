
package com.nttdata.tim.now.data.bean.monitoring.agcom;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioAgcomT3Bean extends AbstractOutputBean {

	private static final long serialVersionUID = -8589298826143423615L;

	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataRif")
	private Date dataRif;
	
	@JsonProperty("giacenzaScadutaA_DAC_LA_GIAC")
	private String giacenzaScadutaADacLaGiac;
	
	@JsonProperty("giacenzaScadutaA_DAC_LA_SCAD")
	private String giacenzaScadutaADacLaScad;
	
	@JsonProperty("giacenzaScadutaA_DAC_LA_PERC")
	private String giacenzaScadutaADacLaPerc;
	
	@JsonProperty("giacenzaScadutaA_DAC_LNA_GIAC")
	private String giacenzaScadutaADacLnaGiac;
	
	@JsonProperty("giacenzaScadutaA_DAC_LNA_SCAD")
	private String giacenzaScadutaADacLnaScad;
	
	@JsonProperty("giacenzaScadutaA_DAC_LNA_PERC")
	private String giacenzaScadutaADacLnaPerc;
	
	@JsonProperty("giacenzaScadutaA_DAC_TOT_GIAC")
	private String giacenzaScadutaADacTotGiac;

	@JsonProperty("giacenzaScadutaA_DAC_TOT_SCAD")
	private String giacenzaScadutaADacTotScad;
	
	@JsonProperty("giacenzaScadutaA_DAC_TOT_PERC")
	private String giacenzaScadutaADacTotPerc;
	
	@JsonProperty("giacenzaScadutaA_DAC_LA_LNA_GIAC")
	private String giacenzaScadutaADacLaLnaGiac;
	
	@JsonProperty("giacenzaScadutaA_DAC_LA_LNA_SCAD")
	private String giacenzaScadutaADacLaLnaScad;
	
	@JsonProperty("giacenzaScadutaA_DAC_LA_LNA_PERC")
	private String giacenzaScadutaADacLaLnaPerc;
	
	@JsonProperty("totaleDAC_SLA_GIAC")
	private String totaleDacSlaGiac;
	
	@JsonProperty("totaleDAC_SLA_SCAD")
	private String totaleDacSlaScad;
	
	@JsonProperty("totaleDAC_SLA_PERC")
	private String totaleDacSlaPerc;
	
	@JsonProperty("tipo")
	private String tipo;

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	public String getGiacenzaScadutaADacLaGiac() {
		return giacenzaScadutaADacLaGiac;
	}

	public void setGiacenzaScadutaADacLaGiac(String giacenzaScadutaADacLaGiac) {
		this.giacenzaScadutaADacLaGiac = giacenzaScadutaADacLaGiac;
	}

	public String getGiacenzaScadutaADacLaScad() {
		return giacenzaScadutaADacLaScad;
	}

	public void setGiacenzaScadutaADacLaScad(String giacenzaScadutaADacLaScad) {
		this.giacenzaScadutaADacLaScad = giacenzaScadutaADacLaScad;
	}

	public String getGiacenzaScadutaADacLaPerc() {
		return giacenzaScadutaADacLaPerc;
	}

	public void setGiacenzaScadutaADacLaPerc(String giacenzaScadutaADacLaPerc) {
		this.giacenzaScadutaADacLaPerc = giacenzaScadutaADacLaPerc;
	}

	public String getGiacenzaScadutaADacLnaGiac() {
		return giacenzaScadutaADacLnaGiac;
	}

	public void setGiacenzaScadutaADacLnaGiac(String giacenzaScadutaADacLnaGiac) {
		this.giacenzaScadutaADacLnaGiac = giacenzaScadutaADacLnaGiac;
	}

	public String getGiacenzaScadutaADacLnaScad() {
		return giacenzaScadutaADacLnaScad;
	}

	public void setGiacenzaScadutaADacLnaScad(String giacenzaScadutaADacLnaScad) {
		this.giacenzaScadutaADacLnaScad = giacenzaScadutaADacLnaScad;
	}

	public String getGiacenzaScadutaADacLnaPerc() {
		return giacenzaScadutaADacLnaPerc;
	}

	public void setGiacenzaScadutaADacLnaPerc(String giacenzaScadutaADacLnaPerc) {
		this.giacenzaScadutaADacLnaPerc = giacenzaScadutaADacLnaPerc;
	}

	public String getGiacenzaScadutaADacTotGiac() {
		return giacenzaScadutaADacTotGiac;
	}

	public void setGiacenzaScadutaADacTotGiac(String giacenzaScadutaADacTotGiac) {
		this.giacenzaScadutaADacTotGiac = giacenzaScadutaADacTotGiac;
	}

	public String getGiacenzaScadutaADacTotScad() {
		return giacenzaScadutaADacTotScad;
	}

	public void setGiacenzaScadutaADacTotScad(String giacenzaScadutaADacTotScad) {
		this.giacenzaScadutaADacTotScad = giacenzaScadutaADacTotScad;
	}

	public String getGiacenzaScadutaADacTotPerc() {
		return giacenzaScadutaADacTotPerc;
	}

	public void setGiacenzaScadutaADacTotPerc(String giacenzaScadutaADacTotPerc) {
		this.giacenzaScadutaADacTotPerc = giacenzaScadutaADacTotPerc;
	}

	public String getGiacenzaScadutaADacLaLnaGiac() {
		return giacenzaScadutaADacLaLnaGiac;
	}

	public void setGiacenzaScadutaADacLaLnaGiac(String giacenzaScadutaADacLaLnaGiac) {
		this.giacenzaScadutaADacLaLnaGiac = giacenzaScadutaADacLaLnaGiac;
	}

	public String getGiacenzaScadutaADacLaLnaScad() {
		return giacenzaScadutaADacLaLnaScad;
	}

	public void setGiacenzaScadutaADacLaLnaScad(String giacenzaScadutaADacLaLnaScad) {
		this.giacenzaScadutaADacLaLnaScad = giacenzaScadutaADacLaLnaScad;
	}

	public String getGiacenzaScadutaADacLaLnaPerc() {
		return giacenzaScadutaADacLaLnaPerc;
	}

	public void setGiacenzaScadutaADacLaLnaPerc(String giacenzaScadutaADacLaLnaPerc) {
		this.giacenzaScadutaADacLaLnaPerc = giacenzaScadutaADacLaLnaPerc;
	}

	public String getTotaleDacSlaGiac() {
		return totaleDacSlaGiac;
	}

	public void setTotaleDacSlaGiac(String totaleDacSlaGiac) {
		this.totaleDacSlaGiac = totaleDacSlaGiac;
	}

	public String getTotaleDacSlaScad() {
		return totaleDacSlaScad;
	}

	public void setTotaleDacSlaScad(String totaleDacSlaScad) {
		this.totaleDacSlaScad = totaleDacSlaScad;
	}

	public String getTotaleDacSlaPerc() {
		return totaleDacSlaPerc;
	}

	public void setTotaleDacSlaPerc(String totaleDacSlaPerc) {
		this.totaleDacSlaPerc = totaleDacSlaPerc;
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
		result = prime * result + ((giacenzaScadutaADacLaGiac == null) ? 0 : giacenzaScadutaADacLaGiac.hashCode());
		result = prime * result
				+ ((giacenzaScadutaADacLaLnaGiac == null) ? 0 : giacenzaScadutaADacLaLnaGiac.hashCode());
		result = prime * result
				+ ((giacenzaScadutaADacLaLnaPerc == null) ? 0 : giacenzaScadutaADacLaLnaPerc.hashCode());
		result = prime * result
				+ ((giacenzaScadutaADacLaLnaScad == null) ? 0 : giacenzaScadutaADacLaLnaScad.hashCode());
		result = prime * result + ((giacenzaScadutaADacLaPerc == null) ? 0 : giacenzaScadutaADacLaPerc.hashCode());
		result = prime * result + ((giacenzaScadutaADacLaScad == null) ? 0 : giacenzaScadutaADacLaScad.hashCode());
		result = prime * result + ((giacenzaScadutaADacLnaGiac == null) ? 0 : giacenzaScadutaADacLnaGiac.hashCode());
		result = prime * result + ((giacenzaScadutaADacLnaPerc == null) ? 0 : giacenzaScadutaADacLnaPerc.hashCode());
		result = prime * result + ((giacenzaScadutaADacLnaScad == null) ? 0 : giacenzaScadutaADacLnaScad.hashCode());
		result = prime * result + ((giacenzaScadutaADacTotGiac == null) ? 0 : giacenzaScadutaADacTotGiac.hashCode());
		result = prime * result + ((giacenzaScadutaADacTotPerc == null) ? 0 : giacenzaScadutaADacTotPerc.hashCode());
		result = prime * result + ((giacenzaScadutaADacTotScad == null) ? 0 : giacenzaScadutaADacTotScad.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((totaleDacSlaGiac == null) ? 0 : totaleDacSlaGiac.hashCode());
		result = prime * result + ((totaleDacSlaPerc == null) ? 0 : totaleDacSlaPerc.hashCode());
		result = prime * result + ((totaleDacSlaScad == null) ? 0 : totaleDacSlaScad.hashCode());
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
		MonitoraggioAgcomT3Bean other = (MonitoraggioAgcomT3Bean) obj;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (giacenzaScadutaADacLaGiac == null) {
			if (other.giacenzaScadutaADacLaGiac != null)
				return false;
		} else if (!giacenzaScadutaADacLaGiac.equals(other.giacenzaScadutaADacLaGiac))
			return false;
		if (giacenzaScadutaADacLaLnaGiac == null) {
			if (other.giacenzaScadutaADacLaLnaGiac != null)
				return false;
		} else if (!giacenzaScadutaADacLaLnaGiac.equals(other.giacenzaScadutaADacLaLnaGiac))
			return false;
		if (giacenzaScadutaADacLaLnaPerc == null) {
			if (other.giacenzaScadutaADacLaLnaPerc != null)
				return false;
		} else if (!giacenzaScadutaADacLaLnaPerc.equals(other.giacenzaScadutaADacLaLnaPerc))
			return false;
		if (giacenzaScadutaADacLaLnaScad == null) {
			if (other.giacenzaScadutaADacLaLnaScad != null)
				return false;
		} else if (!giacenzaScadutaADacLaLnaScad.equals(other.giacenzaScadutaADacLaLnaScad))
			return false;
		if (giacenzaScadutaADacLaPerc == null) {
			if (other.giacenzaScadutaADacLaPerc != null)
				return false;
		} else if (!giacenzaScadutaADacLaPerc.equals(other.giacenzaScadutaADacLaPerc))
			return false;
		if (giacenzaScadutaADacLaScad == null) {
			if (other.giacenzaScadutaADacLaScad != null)
				return false;
		} else if (!giacenzaScadutaADacLaScad.equals(other.giacenzaScadutaADacLaScad))
			return false;
		if (giacenzaScadutaADacLnaGiac == null) {
			if (other.giacenzaScadutaADacLnaGiac != null)
				return false;
		} else if (!giacenzaScadutaADacLnaGiac.equals(other.giacenzaScadutaADacLnaGiac))
			return false;
		if (giacenzaScadutaADacLnaPerc == null) {
			if (other.giacenzaScadutaADacLnaPerc != null)
				return false;
		} else if (!giacenzaScadutaADacLnaPerc.equals(other.giacenzaScadutaADacLnaPerc))
			return false;
		if (giacenzaScadutaADacLnaScad == null) {
			if (other.giacenzaScadutaADacLnaScad != null)
				return false;
		} else if (!giacenzaScadutaADacLnaScad.equals(other.giacenzaScadutaADacLnaScad))
			return false;
		if (giacenzaScadutaADacTotGiac == null) {
			if (other.giacenzaScadutaADacTotGiac != null)
				return false;
		} else if (!giacenzaScadutaADacTotGiac.equals(other.giacenzaScadutaADacTotGiac))
			return false;
		if (giacenzaScadutaADacTotPerc == null) {
			if (other.giacenzaScadutaADacTotPerc != null)
				return false;
		} else if (!giacenzaScadutaADacTotPerc.equals(other.giacenzaScadutaADacTotPerc))
			return false;
		if (giacenzaScadutaADacTotScad == null) {
			if (other.giacenzaScadutaADacTotScad != null)
				return false;
		} else if (!giacenzaScadutaADacTotScad.equals(other.giacenzaScadutaADacTotScad))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (totaleDacSlaGiac == null) {
			if (other.totaleDacSlaGiac != null)
				return false;
		} else if (!totaleDacSlaGiac.equals(other.totaleDacSlaGiac))
			return false;
		if (totaleDacSlaPerc == null) {
			if (other.totaleDacSlaPerc != null)
				return false;
		} else if (!totaleDacSlaPerc.equals(other.totaleDacSlaPerc))
			return false;
		if (totaleDacSlaScad == null) {
			if (other.totaleDacSlaScad != null)
				return false;
		} else if (!totaleDacSlaScad.equals(other.totaleDacSlaScad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonitoraggioAgcomT3Bean [dataRif=" + dataRif + ", giacenzaScadutaADacLaGiac="
				+ giacenzaScadutaADacLaGiac + ", giacenzaScadutaADacLaScad=" + giacenzaScadutaADacLaScad
				+ ", giacenzaScadutaADacLaPerc=" + giacenzaScadutaADacLaPerc + ", giacenzaScadutaADacLnaGiac="
				+ giacenzaScadutaADacLnaGiac + ", giacenzaScadutaADacLnaScad=" + giacenzaScadutaADacLnaScad
				+ ", giacenzaScadutaADacLnaPerc=" + giacenzaScadutaADacLnaPerc + ", giacenzaScadutaADacTotGiac="
				+ giacenzaScadutaADacTotGiac + ", giacenzaScadutaADacTotScad=" + giacenzaScadutaADacTotScad
				+ ", giacenzaScadutaADacTotPerc=" + giacenzaScadutaADacTotPerc + ", giacenzaScadutaADacLaLnaGiac="
				+ giacenzaScadutaADacLaLnaGiac + ", giacenzaScadutaADacLaLnaScad=" + giacenzaScadutaADacLaLnaScad
				+ ", giacenzaScadutaADacLaLnaPerc=" + giacenzaScadutaADacLaLnaPerc + ", totaleDacSlaGiac="
				+ totaleDacSlaGiac + ", totaleDacSlaScad=" + totaleDacSlaScad + ", totaleDacSlaPerc=" + totaleDacSlaPerc
				+ ", tipo=" + tipo + "]";
	}
	
}
