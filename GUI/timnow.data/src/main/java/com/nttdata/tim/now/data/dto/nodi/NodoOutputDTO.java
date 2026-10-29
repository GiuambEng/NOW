package com.nttdata.tim.now.data.dto.nodi;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
public class NodoOutputDTO implements Serializable {

	private static final long serialVersionUID = 7978794724793886327L;

	@JsonProperty("codiceNodo")
    private String codiceNodo;
	
    @JsonProperty("descrizioneCentrale")
    private String descrizioneCentrale;
    
    @JsonProperty("codiceClli")
    private String codiceClli;

	public String getCodiceNodo() {
		return codiceNodo;
	}

	public void setCodiceNodo(String codiceNodo) {
		this.codiceNodo = codiceNodo;
	}

	public String getDescrizioneCentrale() {
		return descrizioneCentrale;
	}

	public void setDescrizioneCentrale(String descrizioneCentrale) {
		this.descrizioneCentrale = descrizioneCentrale;
	}

	public String getCodiceClli() {
		return codiceClli;
	}

	public void setCodiceClli(String codiceClli) {
		this.codiceClli = codiceClli;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceClli == null) ? 0 : codiceClli.hashCode());
		result = prime * result + ((codiceNodo == null) ? 0 : codiceNodo.hashCode());
		result = prime * result + ((descrizioneCentrale == null) ? 0 : descrizioneCentrale.hashCode());
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
		NodoOutputDTO other = (NodoOutputDTO) obj;
		if (codiceClli == null) {
			if (other.codiceClli != null)
				return false;
		} else if (!codiceClli.equals(other.codiceClli))
			return false;
		if (codiceNodo == null) {
			if (other.codiceNodo != null)
				return false;
		} else if (!codiceNodo.equals(other.codiceNodo))
			return false;
		if (descrizioneCentrale == null) {
			if (other.descrizioneCentrale != null)
				return false;
		} else if (!descrizioneCentrale.equals(other.descrizioneCentrale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NodiOutputDTO [codiceNodo=" + codiceNodo + ", descrizioneCentrale=" + descrizioneCentrale
				+ ", codiceClli=" + codiceClli + "]";
	}
    
       
}
