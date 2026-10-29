package com.nttdata.tim.now.data.bean.areamacroarea;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class AreaMacroareaOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 7408032681438926280L;

	@JsonProperty("tipologiaAdr")
    private String tipologiaAdr;
	
    @JsonProperty("flagAtm")
    private String flagAtm;
    
    @JsonProperty("descrizioneArea")
    private String descrizioneArea;
    
    @JsonProperty("dataInizioValidita")
    private String dataInizioValidita;
    
    @JsonProperty("codiceAdr")
    private String codiceAdr;   
    
    @JsonProperty("dataFineValidita")
    private String dataFineValidita;

	public String getTipologiaAdr() {
		return tipologiaAdr;
	}

	public void setTipologiaAdr(String tipologiaAdr) {
		this.tipologiaAdr = tipologiaAdr;
	}

	public String getFlagAtm() {
		return flagAtm;
	}

	public void setFlagAtm(String flagAtm) {
		this.flagAtm = flagAtm;
	}

	public String getDescrizioneArea() {
		return descrizioneArea;
	}

	public void setDescrizioneArea(String descrizioneArea) {
		this.descrizioneArea = descrizioneArea;
	}

	public String getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(String dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public String getCodiceAdr() {
		return codiceAdr;
	}

	public void setCodiceAdr(String codiceAdr) {
		this.codiceAdr = codiceAdr;
	}

	public String getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceAdr == null) ? 0 : codiceAdr.hashCode());
		result = prime * result + ((dataFineValidita == null) ? 0 : dataFineValidita.hashCode());
		result = prime * result + ((dataInizioValidita == null) ? 0 : dataInizioValidita.hashCode());
		result = prime * result + ((descrizioneArea == null) ? 0 : descrizioneArea.hashCode());
		result = prime * result + ((flagAtm == null) ? 0 : flagAtm.hashCode());
		result = prime * result + ((tipologiaAdr == null) ? 0 : tipologiaAdr.hashCode());
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
		AreaMacroareaOutputBean other = (AreaMacroareaOutputBean) obj;
		if (codiceAdr == null) {
			if (other.codiceAdr != null)
				return false;
		} else if (!codiceAdr.equals(other.codiceAdr))
			return false;
		if (dataFineValidita == null) {
			if (other.dataFineValidita != null)
				return false;
		} else if (!dataFineValidita.equals(other.dataFineValidita))
			return false;
		if (dataInizioValidita == null) {
			if (other.dataInizioValidita != null)
				return false;
		} else if (!dataInizioValidita.equals(other.dataInizioValidita))
			return false;
		if (descrizioneArea == null) {
			if (other.descrizioneArea != null)
				return false;
		} else if (!descrizioneArea.equals(other.descrizioneArea))
			return false;
		if (flagAtm == null) {
			if (other.flagAtm != null)
				return false;
		} else if (!flagAtm.equals(other.flagAtm))
			return false;
		if (tipologiaAdr == null) {
			if (other.tipologiaAdr != null)
				return false;
		} else if (!tipologiaAdr.equals(other.tipologiaAdr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AreaMacroareaOutputBean [tipologiaAdr=" + tipologiaAdr + ", flagAtm=" + flagAtm + ", descrizioneArea="
				+ descrizioneArea + ", dataInizioValidita=" + dataInizioValidita + ", codiceAdr=" + codiceAdr
				+ ", dataFineValidita=" + dataFineValidita + "]";
	}
    
	
}
