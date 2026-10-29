package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class VerificaModelloKitInputDTO implements Serializable {

	private static final long serialVersionUID = 3703946222858763680L;

	@JsonProperty("codiceTdKit")
	private String codiceTdKit;

	@JsonProperty("codiceTdKitAsset")
	private String codiceTdKitAsset;
		
	@JsonProperty("sottolavorazione")
	private String sottolavorazione;
	
	@JsonProperty("offerta")
	private String offerta;

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public String getCodiceTdKitAsset() {
		return codiceTdKitAsset;
	}

	public void setCodiceTdKitAsset(String codiceTdKitAsset) {
		this.codiceTdKitAsset = codiceTdKitAsset;
	}

	public String getSottolavorazione() {
		return sottolavorazione;
	}

	public void setSottolavorazione(String sottolavorazione) {
		this.sottolavorazione = sottolavorazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceTdKit == null) ? 0 : codiceTdKit.hashCode());
		result = prime * result + ((codiceTdKitAsset == null) ? 0 : codiceTdKitAsset.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((sottolavorazione == null) ? 0 : sottolavorazione.hashCode());
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
		VerificaModelloKitInputDTO other = (VerificaModelloKitInputDTO) obj;
		if (codiceTdKit == null) {
			if (other.codiceTdKit != null)
				return false;
		} else if (!codiceTdKit.equals(other.codiceTdKit))
			return false;
		if (codiceTdKitAsset == null) {
			if (other.codiceTdKitAsset != null)
				return false;
		} else if (!codiceTdKitAsset.equals(other.codiceTdKitAsset))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (sottolavorazione == null) {
			if (other.sottolavorazione != null)
				return false;
		} else if (!sottolavorazione.equals(other.sottolavorazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaModelloKitInputDTO [codiceTdKit=" + codiceTdKit + ", codiceTdKitAsset=" + codiceTdKitAsset
				+ ", sottolavorazione=" + sottolavorazione + ", offerta=" + offerta + "]";
	}
		
}
