package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class VerificaKitAbilitatoNGAInputBean implements Serializable {

	private static final long serialVersionUID = -4396701849011102372L;

	@JsonProperty("codiceTdKit")
	private String codiceTdKit;
	
	@JsonProperty("codiceFunzione")
    private String codiceFunzione;

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public String getCodiceFunzione() {
		return codiceFunzione;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public void setCodiceFunzione(String codiceFunzione) {
		this.codiceFunzione = codiceFunzione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFunzione == null) ? 0 : codiceFunzione.hashCode());
		result = prime * result + ((codiceTdKit == null) ? 0 : codiceTdKit.hashCode());
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
		VerificaKitAbilitatoNGAInputBean other = (VerificaKitAbilitatoNGAInputBean) obj;
		if (codiceFunzione == null) {
			if (other.codiceFunzione != null)
				return false;
		} else if (!codiceFunzione.equals(other.codiceFunzione))
			return false;
		if (codiceTdKit == null) {
			if (other.codiceTdKit != null)
				return false;
		} else if (!codiceTdKit.equals(other.codiceTdKit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaKitAbilitatoNGAInputBean [codiceTdKit=" + codiceTdKit + ", codiceFunzione=" + codiceFunzione
				+ "]";
	}


}
