package com.nttdata.tim.now.data.dto.anagraficacoinvestimento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1164
@JsonInclude(Include.NON_NULL)
public class ComuniCoinvestimentoOutputDTO implements Serializable {

	private static final long serialVersionUID = -8296876149623461036L;

	@JsonProperty("istatComune")
    private String istatComune;
	
    @JsonProperty("descrComune")
    private String descrComune;
    
    @JsonProperty("dataInizioCoinvestimento")
    private String dataInizioCoinvestimento;
    
    @JsonProperty("dataFineCoinvestimento")
    private String dataFineCoinvestimento;
    
    @JsonProperty("codiceContratto")
    private String codiceContratto;
    
    @JsonProperty("offerta")
    private String offerta;
    
    @JsonProperty("codOloAgcom")
    private String codOloAgcom;

	public String getIstatComune() {
		return istatComune;
	}

	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

	public String getDescrComune() {
		return descrComune;
	}

	public void setDescrComune(String descrComune) {
		this.descrComune = descrComune;
	}

	public String getDataInizioCoinvestimento() {
		return dataInizioCoinvestimento;
	}

	public void setDataInizioCoinvestimento(String dataInizioCoinvestimento) {
		this.dataInizioCoinvestimento = dataInizioCoinvestimento;
	}

	public String getDataFineCoinvestimento() {
		return dataFineCoinvestimento;
	}

	public void setDataFineCoinvestimento(String dataFineCoinvestimento) {
		this.dataFineCoinvestimento = dataFineCoinvestimento;
	}

	public String getCodiceContratto() {
		return codiceContratto;
	}

	public void setCodiceContratto(String codiceContratto) {
		this.codiceContratto = codiceContratto;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codiceContratto == null) ? 0 : codiceContratto.hashCode());
		result = prime * result + ((dataFineCoinvestimento == null) ? 0 : dataFineCoinvestimento.hashCode());
		result = prime * result + ((dataInizioCoinvestimento == null) ? 0 : dataInizioCoinvestimento.hashCode());
		result = prime * result + ((descrComune == null) ? 0 : descrComune.hashCode());
		result = prime * result + ((istatComune == null) ? 0 : istatComune.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
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
		ComuniCoinvestimentoOutputDTO other = (ComuniCoinvestimentoOutputDTO) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (codiceContratto == null) {
			if (other.codiceContratto != null)
				return false;
		} else if (!codiceContratto.equals(other.codiceContratto))
			return false;
		if (dataFineCoinvestimento == null) {
			if (other.dataFineCoinvestimento != null)
				return false;
		} else if (!dataFineCoinvestimento.equals(other.dataFineCoinvestimento))
			return false;
		if (dataInizioCoinvestimento == null) {
			if (other.dataInizioCoinvestimento != null)
				return false;
		} else if (!dataInizioCoinvestimento.equals(other.dataInizioCoinvestimento))
			return false;
		if (descrComune == null) {
			if (other.descrComune != null)
				return false;
		} else if (!descrComune.equals(other.descrComune))
			return false;
		if (istatComune == null) {
			if (other.istatComune != null)
				return false;
		} else if (!istatComune.equals(other.istatComune))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComuniCoinvestimentoOutputDTO [istatComune=" + istatComune + ", descrComune=" + descrComune
				+ ", dataInizioCoinvestimento=" + dataInizioCoinvestimento + ", dataFineCoinvestimento="
				+ dataFineCoinvestimento + ", codiceContratto=" + codiceContratto + ", offerta=" + offerta
				+ ", codOloAgcom=" + codOloAgcom + "]";
	}
}
