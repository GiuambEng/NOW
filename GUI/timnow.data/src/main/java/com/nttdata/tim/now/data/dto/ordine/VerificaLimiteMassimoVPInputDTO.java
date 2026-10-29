package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class VerificaLimiteMassimoVPInputDTO implements Serializable {

	private static final long serialVersionUID = 5956514396781144151L;

	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("codiceTDKit")
    private String codiceTDKit;
	
	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getCodiceTDKit() {
		return codiceTDKit;
	}

	public void setCodiceTDKit(String codiceTDKit) {
		this.codiceTDKit = codiceTDKit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceTDKit == null) ? 0 : codiceTDKit.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
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
		VerificaLimiteMassimoVPInputDTO other = (VerificaLimiteMassimoVPInputDTO) obj;
		if (codiceTDKit == null) {
			if (other.codiceTDKit != null)
				return false;
		} else if (!codiceTDKit.equals(other.codiceTDKit))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaKitAbilitatoNGAInputDTO [idOfferta=" + idOfferta + ", codiceTDKit=" + codiceTDKit + "]";
	}
	
}
