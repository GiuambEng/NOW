package com.nttdata.tim.now.data.dto.ordine.dettaglio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_918
@JsonInclude(Include.NON_NULL)
public class CambioTecnologiaDTO implements Serializable {

	private static final long serialVersionUID = -1670073711194398287L;

	@JsonProperty("valore")
    private String valore;

    @JsonProperty("label")
    private String label;

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((valore == null) ? 0 : valore.hashCode());
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
		CambioTecnologiaDTO other = (CambioTecnologiaDTO) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (valore == null) {
			if (other.valore != null)
				return false;
		} else if (!valore.equals(other.valore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CambioTecnologiaDTO [valore=" + valore + ", label=" + label + "]";
	}

  

}
