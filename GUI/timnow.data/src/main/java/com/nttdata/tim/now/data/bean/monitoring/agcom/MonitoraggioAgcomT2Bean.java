
package com.nttdata.tim.now.data.bean.monitoring.agcom;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioAgcomT2Bean extends AbstractOutputBean {

	private static final long serialVersionUID = 8717957085553621236L;

	@JsonProperty("olo")
	private String olo;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataRif")
	private Date dataRif;
	
	@JsonProperty("giacenzaEntroPrimaDAC_OLO_SLAsuGiacenza")
	private String giacenzaEntroPrimaDacOloSlaSuGiacenza;
	
	@JsonProperty("giacenzaOltrePrimaDAC_OLO_SLAsuGiacenza")
	private String giacenzaOltrePrimaDacOloSlasuGiacenza;
	
	@JsonProperty("giacenzaRimodulataSuGiacenza")
	private String giacenzaRimodulataSuGiacenza;
	
	@JsonProperty("giacenzaA_DACScadutaSuGiacenza")
	private String giacenzaADacScadutaSuGiacenza;
	
	@JsonProperty("giacenzaScadutaTotSuGiacenza")
	private String giacenzaScadutaTotSuGiacenza;
	
	@JsonProperty("koSuLavorati")
	private String koSuLavorati;
	
	@JsonProperty("okSULavorati")
	private String okSuLavorati;
	
	@JsonProperty("tipo")
	private String tipo;

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public Date getDataRif() {
		return dataRif;
	}

	public void setDataRif(Date dataRif) {
		this.dataRif = dataRif;
	}

	public String getGiacenzaEntroPrimaDacOloSlaSuGiacenza() {
		return giacenzaEntroPrimaDacOloSlaSuGiacenza;
	}

	public void setGiacenzaEntroPrimaDacOloSlaSuGiacenza(String giacenzaEntroPrimaDacOloSlaSuGiacenza) {
		this.giacenzaEntroPrimaDacOloSlaSuGiacenza = giacenzaEntroPrimaDacOloSlaSuGiacenza;
	}

	public String getGiacenzaOltrePrimaDacOloSlasuGiacenza() {
		return giacenzaOltrePrimaDacOloSlasuGiacenza;
	}

	public void setGiacenzaOltrePrimaDacOloSlasuGiacenza(String giacenzaOltrePrimaDacOloSlasuGiacenza) {
		this.giacenzaOltrePrimaDacOloSlasuGiacenza = giacenzaOltrePrimaDacOloSlasuGiacenza;
	}

	public String getGiacenzaRimodulataSuGiacenza() {
		return giacenzaRimodulataSuGiacenza;
	}

	public void setGiacenzaRimodulataSuGiacenza(String giacenzaRimodulataSuGiacenza) {
		this.giacenzaRimodulataSuGiacenza = giacenzaRimodulataSuGiacenza;
	}

	public String getGiacenzaADacScadutaSuGiacenza() {
		return giacenzaADacScadutaSuGiacenza;
	}

	public void setGiacenzaADacScadutaSuGiacenza(String giacenzaADacScadutaSuGiacenza) {
		this.giacenzaADacScadutaSuGiacenza = giacenzaADacScadutaSuGiacenza;
	}

	public String getGiacenzaScadutaTotSuGiacenza() {
		return giacenzaScadutaTotSuGiacenza;
	}

	public void setGiacenzaScadutaTotSuGiacenza(String giacenzaScadutaTotSuGiacenza) {
		this.giacenzaScadutaTotSuGiacenza = giacenzaScadutaTotSuGiacenza;
	}

	public String getKoSuLavorati() {
		return koSuLavorati;
	}

	public void setKoSuLavorati(String koSuLavorati) {
		this.koSuLavorati = koSuLavorati;
	}

	public String getOkSuLavorati() {
		return okSuLavorati;
	}

	public void setOkSuLavorati(String okSuLavorati) {
		this.okSuLavorati = okSuLavorati;
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
		result = prime * result
				+ ((giacenzaADacScadutaSuGiacenza == null) ? 0 : giacenzaADacScadutaSuGiacenza.hashCode());
		result = prime * result + ((giacenzaEntroPrimaDacOloSlaSuGiacenza == null) ? 0
				: giacenzaEntroPrimaDacOloSlaSuGiacenza.hashCode());
		result = prime * result + ((giacenzaOltrePrimaDacOloSlasuGiacenza == null) ? 0
				: giacenzaOltrePrimaDacOloSlasuGiacenza.hashCode());
		result = prime * result
				+ ((giacenzaRimodulataSuGiacenza == null) ? 0 : giacenzaRimodulataSuGiacenza.hashCode());
		result = prime * result
				+ ((giacenzaScadutaTotSuGiacenza == null) ? 0 : giacenzaScadutaTotSuGiacenza.hashCode());
		result = prime * result + ((koSuLavorati == null) ? 0 : koSuLavorati.hashCode());
		result = prime * result + ((okSuLavorati == null) ? 0 : okSuLavorati.hashCode());
		result = prime * result + ((olo == null) ? 0 : olo.hashCode());
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
		MonitoraggioAgcomT2Bean other = (MonitoraggioAgcomT2Bean) obj;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (giacenzaADacScadutaSuGiacenza == null) {
			if (other.giacenzaADacScadutaSuGiacenza != null)
				return false;
		} else if (!giacenzaADacScadutaSuGiacenza.equals(other.giacenzaADacScadutaSuGiacenza))
			return false;
		if (giacenzaEntroPrimaDacOloSlaSuGiacenza == null) {
			if (other.giacenzaEntroPrimaDacOloSlaSuGiacenza != null)
				return false;
		} else if (!giacenzaEntroPrimaDacOloSlaSuGiacenza.equals(other.giacenzaEntroPrimaDacOloSlaSuGiacenza))
			return false;
		if (giacenzaOltrePrimaDacOloSlasuGiacenza == null) {
			if (other.giacenzaOltrePrimaDacOloSlasuGiacenza != null)
				return false;
		} else if (!giacenzaOltrePrimaDacOloSlasuGiacenza.equals(other.giacenzaOltrePrimaDacOloSlasuGiacenza))
			return false;
		if (giacenzaRimodulataSuGiacenza == null) {
			if (other.giacenzaRimodulataSuGiacenza != null)
				return false;
		} else if (!giacenzaRimodulataSuGiacenza.equals(other.giacenzaRimodulataSuGiacenza))
			return false;
		if (giacenzaScadutaTotSuGiacenza == null) {
			if (other.giacenzaScadutaTotSuGiacenza != null)
				return false;
		} else if (!giacenzaScadutaTotSuGiacenza.equals(other.giacenzaScadutaTotSuGiacenza))
			return false;
		if (koSuLavorati == null) {
			if (other.koSuLavorati != null)
				return false;
		} else if (!koSuLavorati.equals(other.koSuLavorati))
			return false;
		if (okSuLavorati == null) {
			if (other.okSuLavorati != null)
				return false;
		} else if (!okSuLavorati.equals(other.okSuLavorati))
			return false;
		if (olo == null) {
			if (other.olo != null)
				return false;
		} else if (!olo.equals(other.olo))
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
		return "MonitoraggioAgcomT2Bean [olo=" + olo + ", dataRif=" + dataRif
				+ ", giacenzaEntroPrimaDacOloSlaSuGiacenza=" + giacenzaEntroPrimaDacOloSlaSuGiacenza
				+ ", giacenzaOltrePrimaDacOloSlasuGiacenza=" + giacenzaOltrePrimaDacOloSlasuGiacenza
				+ ", giacenzaRimodulataSuGiacenza=" + giacenzaRimodulataSuGiacenza + ", giacenzaADacScadutaSuGiacenza="
				+ giacenzaADacScadutaSuGiacenza + ", giacenzaScadutaTotSuGiacenza=" + giacenzaScadutaTotSuGiacenza
				+ ", koSuLavorati=" + koSuLavorati + ", okSuLavorati=" + okSuLavorati + ", tipo=" + tipo + "]";
	}

}
