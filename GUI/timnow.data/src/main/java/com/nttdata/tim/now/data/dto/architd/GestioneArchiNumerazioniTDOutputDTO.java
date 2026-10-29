package com.nttdata.tim.now.data.dto.architd;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class GestioneArchiNumerazioniTDOutputDTO implements Serializable {

	private static final long serialVersionUID = 7768527312834456454L;

	@JsonProperty("TD_parziale")
	private String tdParziale;

	@JsonProperty("TD_current")
	private String tdCurrent;
	
	@JsonProperty("TD_min")
	private String tdMin;
	
	@JsonProperty("TD_max")
	private String tdMax;
	
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("Inizio_validita")
	private Date inizioValidita;
	
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("Fine_validita")
	private Date fineValidita;
	
	@JsonProperty("Active_flag")
	private String activeFlag;
	
	@JsonProperty("operatore")
	private String operatore;

	public String getTdParziale() {
		return tdParziale;
	}

	public void setTdParziale(String tdParziale) {
		this.tdParziale = tdParziale;
	}

	public String getTdCurrent() {
		return tdCurrent;
	}

	public void setTdCurrent(String tdCurrent) {
		this.tdCurrent = tdCurrent;
	}

	public String getTdMin() {
		return tdMin;
	}

	public void setTdMin(String tdMin) {
		this.tdMin = tdMin;
	}

	public String getTdMax() {
		return tdMax;
	}

	public void setTdMax(String tdMax) {
		this.tdMax = tdMax;
	}

	public Date getInizioValidita() {
		return inizioValidita;
	}

	public void setInizioValidita(Date inizioValidita) {
		this.inizioValidita = inizioValidita;
	}

	public Date getFineValidita() {
		return fineValidita;
	}

	public void setFineValidita(Date fineValidita) {
		this.fineValidita = fineValidita;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeFlag == null) ? 0 : activeFlag.hashCode());
		result = prime * result + ((fineValidita == null) ? 0 : fineValidita.hashCode());
		result = prime * result + ((inizioValidita == null) ? 0 : inizioValidita.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((tdCurrent == null) ? 0 : tdCurrent.hashCode());
		result = prime * result + ((tdMax == null) ? 0 : tdMax.hashCode());
		result = prime * result + ((tdMin == null) ? 0 : tdMin.hashCode());
		result = prime * result + ((tdParziale == null) ? 0 : tdParziale.hashCode());
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
		GestioneArchiNumerazioniTDOutputDTO other = (GestioneArchiNumerazioniTDOutputDTO) obj;
		if (activeFlag == null) {
			if (other.activeFlag != null)
				return false;
		} else if (!activeFlag.equals(other.activeFlag))
			return false;
		if (fineValidita == null) {
			if (other.fineValidita != null)
				return false;
		} else if (!fineValidita.equals(other.fineValidita))
			return false;
		if (inizioValidita == null) {
			if (other.inizioValidita != null)
				return false;
		} else if (!inizioValidita.equals(other.inizioValidita))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (tdCurrent == null) {
			if (other.tdCurrent != null)
				return false;
		} else if (!tdCurrent.equals(other.tdCurrent))
			return false;
		if (tdMax == null) {
			if (other.tdMax != null)
				return false;
		} else if (!tdMax.equals(other.tdMax))
			return false;
		if (tdMin == null) {
			if (other.tdMin != null)
				return false;
		} else if (!tdMin.equals(other.tdMin))
			return false;
		if (tdParziale == null) {
			if (other.tdParziale != null)
				return false;
		} else if (!tdParziale.equals(other.tdParziale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GestioneArchiNumerazioniTDOutputDTO [tdParziale=" + tdParziale + ", tdCurrent=" + tdCurrent + ", tdMin="
				+ tdMin + ", tdMax=" + tdMax + ", inizioValidita=" + inizioValidita + ", fineValidita=" + fineValidita
				+ ", activeFlag=" + activeFlag + ", operatore=" + operatore + "]";
	}


    
}