
package com.nttdata.tim.now.data.bean.monitoring.agcom;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioAgcomT1Bean extends AbstractOutputBean {

	private static final long serialVersionUID = 8065779179366382876L;

	@JsonProperty("olo")
	private String olo;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataRif")
	private Date dataRif;
	
	@JsonProperty("lavorati")
	private String lavorati;
	
	@JsonProperty("ok")
	private String ok;
	
	@JsonProperty("ko")
	private String ko;
	
	@JsonProperty("giacenza")
	private String giacenza;
	
	@JsonProperty("entroPrimaDAC_SLA")
	private String entroPrimaDacSla;
	
	@JsonProperty("oltrePrimaDAC_SLA")
	private String oltrePrimaDacSla;
	
	@JsonProperty("diCuiGiacenzaRIM")
	private String diCuiGiacenzaRim;
	
	@JsonProperty("diCuiFuoriSLA")
	private String diCuiFuoriSla;
	
	@JsonProperty("diCuiGiacenzaDAC_Scaduta")
	private String diCuiGiacenzaDacScaduta;
	
	@JsonProperty("giacenzaScadutaTotaleDACeSLA")
	private String giacenzaScadutaTotaleDacESla;
	
	@JsonProperty("giacenzaScadutaTotaleSuGiacenza")
	private String giacenzaScadutaTotaleSuGiacenza;
	
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

	public String getLavorati() {
		return lavorati;
	}

	public void setLavorati(String lavorati) {
		this.lavorati = lavorati;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public String getKo() {
		return ko;
	}

	public void setKo(String ko) {
		this.ko = ko;
	}

	public String getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(String giacenza) {
		this.giacenza = giacenza;
	}

	public String getEntroPrimaDacSla() {
		return entroPrimaDacSla;
	}

	public void setEntroPrimaDacSla(String entroPrimaDacSla) {
		this.entroPrimaDacSla = entroPrimaDacSla;
	}

	public String getOltrePrimaDacSla() {
		return oltrePrimaDacSla;
	}

	public void setOltrePrimaDacSla(String oltrePrimaDacSla) {
		this.oltrePrimaDacSla = oltrePrimaDacSla;
	}

	public String getDiCuiGiacenzaRim() {
		return diCuiGiacenzaRim;
	}

	public void setDiCuiGiacenzaRim(String diCuiGiacenzaRim) {
		this.diCuiGiacenzaRim = diCuiGiacenzaRim;
	}

	public String getDiCuiFuoriSla() {
		return diCuiFuoriSla;
	}

	public void setDiCuiFuoriSla(String diCuiFuoriSla) {
		this.diCuiFuoriSla = diCuiFuoriSla;
	}

	public String getDiCuiGiacenzaDacScaduta() {
		return diCuiGiacenzaDacScaduta;
	}

	public void setDiCuiGiacenzaDacScaduta(String diCuiGiacenzaDacScaduta) {
		this.diCuiGiacenzaDacScaduta = diCuiGiacenzaDacScaduta;
	}

	public String getGiacenzaScadutaTotaleDacESla() {
		return giacenzaScadutaTotaleDacESla;
	}

	public void setGiacenzaScadutaTotaleDacESla(String giacenzaScadutaTotaleDacESla) {
		this.giacenzaScadutaTotaleDacESla = giacenzaScadutaTotaleDacESla;
	}

	public String getGiacenzaScadutaTotaleSuGiacenza() {
		return giacenzaScadutaTotaleSuGiacenza;
	}

	public void setGiacenzaScadutaTotaleSuGiacenza(String giacenzaScadutaTotaleSuGiacenza) {
		this.giacenzaScadutaTotaleSuGiacenza = giacenzaScadutaTotaleSuGiacenza;
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
		result = prime * result + ((diCuiFuoriSla == null) ? 0 : diCuiFuoriSla.hashCode());
		result = prime * result + ((diCuiGiacenzaDacScaduta == null) ? 0 : diCuiGiacenzaDacScaduta.hashCode());
		result = prime * result + ((diCuiGiacenzaRim == null) ? 0 : diCuiGiacenzaRim.hashCode());
		result = prime * result + ((entroPrimaDacSla == null) ? 0 : entroPrimaDacSla.hashCode());
		result = prime * result + ((giacenza == null) ? 0 : giacenza.hashCode());
		result = prime * result
				+ ((giacenzaScadutaTotaleDacESla == null) ? 0 : giacenzaScadutaTotaleDacESla.hashCode());
		result = prime * result
				+ ((giacenzaScadutaTotaleSuGiacenza == null) ? 0 : giacenzaScadutaTotaleSuGiacenza.hashCode());
		result = prime * result + ((ko == null) ? 0 : ko.hashCode());
		result = prime * result + ((lavorati == null) ? 0 : lavorati.hashCode());
		result = prime * result + ((ok == null) ? 0 : ok.hashCode());
		result = prime * result + ((olo == null) ? 0 : olo.hashCode());
		result = prime * result + ((oltrePrimaDacSla == null) ? 0 : oltrePrimaDacSla.hashCode());
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
		MonitoraggioAgcomT1Bean other = (MonitoraggioAgcomT1Bean) obj;
		if (dataRif == null) {
			if (other.dataRif != null)
				return false;
		} else if (!dataRif.equals(other.dataRif))
			return false;
		if (diCuiFuoriSla == null) {
			if (other.diCuiFuoriSla != null)
				return false;
		} else if (!diCuiFuoriSla.equals(other.diCuiFuoriSla))
			return false;
		if (diCuiGiacenzaDacScaduta == null) {
			if (other.diCuiGiacenzaDacScaduta != null)
				return false;
		} else if (!diCuiGiacenzaDacScaduta.equals(other.diCuiGiacenzaDacScaduta))
			return false;
		if (diCuiGiacenzaRim == null) {
			if (other.diCuiGiacenzaRim != null)
				return false;
		} else if (!diCuiGiacenzaRim.equals(other.diCuiGiacenzaRim))
			return false;
		if (entroPrimaDacSla == null) {
			if (other.entroPrimaDacSla != null)
				return false;
		} else if (!entroPrimaDacSla.equals(other.entroPrimaDacSla))
			return false;
		if (giacenza == null) {
			if (other.giacenza != null)
				return false;
		} else if (!giacenza.equals(other.giacenza))
			return false;
		if (giacenzaScadutaTotaleDacESla == null) {
			if (other.giacenzaScadutaTotaleDacESla != null)
				return false;
		} else if (!giacenzaScadutaTotaleDacESla.equals(other.giacenzaScadutaTotaleDacESla))
			return false;
		if (giacenzaScadutaTotaleSuGiacenza == null) {
			if (other.giacenzaScadutaTotaleSuGiacenza != null)
				return false;
		} else if (!giacenzaScadutaTotaleSuGiacenza.equals(other.giacenzaScadutaTotaleSuGiacenza))
			return false;
		if (ko == null) {
			if (other.ko != null)
				return false;
		} else if (!ko.equals(other.ko))
			return false;
		if (lavorati == null) {
			if (other.lavorati != null)
				return false;
		} else if (!lavorati.equals(other.lavorati))
			return false;
		if (ok == null) {
			if (other.ok != null)
				return false;
		} else if (!ok.equals(other.ok))
			return false;
		if (olo == null) {
			if (other.olo != null)
				return false;
		} else if (!olo.equals(other.olo))
			return false;
		if (oltrePrimaDacSla == null) {
			if (other.oltrePrimaDacSla != null)
				return false;
		} else if (!oltrePrimaDacSla.equals(other.oltrePrimaDacSla))
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
		return "MonitoraggioAgcomT1Bean [olo=" + olo + ", dataRif=" + dataRif + ", lavorati=" + lavorati + ", ok=" + ok
				+ ", ko=" + ko + ", giacenza=" + giacenza + ", entroPrimaDacSla=" + entroPrimaDacSla
				+ ", oltrePrimaDacSla=" + oltrePrimaDacSla + ", diCuiGiacenzaRim=" + diCuiGiacenzaRim
				+ ", diCuiFuoriSla=" + diCuiFuoriSla + ", diCuiGiacenzaDacScaduta=" + diCuiGiacenzaDacScaduta
				+ ", giacenzaScadutaTotaleDacESla=" + giacenzaScadutaTotaleDacESla
				+ ", giacenzaScadutaTotaleSuGiacenza=" + giacenzaScadutaTotaleSuGiacenza + ", tipo=" + tipo + "]";
	}
	
}
