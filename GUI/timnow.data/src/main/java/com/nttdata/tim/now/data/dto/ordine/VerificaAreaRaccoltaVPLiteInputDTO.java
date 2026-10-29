package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class VerificaAreaRaccoltaVPLiteInputDTO implements Serializable {

	private static final long serialVersionUID = 7455032414904464974L;

	@JsonProperty("codiceTDKit")
    private String codiceTDKit;
	
	@JsonProperty("macroArea")
    private String macroArea;

	public String getCodiceTDKit() {
		return codiceTDKit;
	}

	public void setCodiceTDKit(String codiceTDKit) {
		this.codiceTDKit = codiceTDKit;
	}

	public String getMacroArea() {
		return macroArea;
	}

	public void setMacroArea(String macroArea) {
		this.macroArea = macroArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceTDKit == null) ? 0 : codiceTDKit.hashCode());
		result = prime * result + ((macroArea == null) ? 0 : macroArea.hashCode());
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
		VerificaAreaRaccoltaVPLiteInputDTO other = (VerificaAreaRaccoltaVPLiteInputDTO) obj;
		if (codiceTDKit == null) {
			if (other.codiceTDKit != null)
				return false;
		} else if (!codiceTDKit.equals(other.codiceTDKit))
			return false;
		if (macroArea == null) {
			if (other.macroArea != null)
				return false;
		} else if (!macroArea.equals(other.macroArea))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaAreaRaccoltaVPLiteInputDTO [codiceTDKit=" + codiceTDKit + ", macroArea=" + macroArea + "]";
	}
	
	
	
}
