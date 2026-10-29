package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TaglioRicaricaOutputBean implements Serializable {

	private static final long serialVersionUID = -2875099724788973440L;

	@JsonProperty("taglioRicarica")
    private String taglioRicarica;

	public String getTaglioRicarica() {
		return taglioRicarica;
	}

	public void setTaglioRicarica(String taglioRicarica) {
		this.taglioRicarica = taglioRicarica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taglioRicarica == null) ? 0 : taglioRicarica.hashCode());
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
		TaglioRicaricaOutputBean other = (TaglioRicaricaOutputBean) obj;
		if (taglioRicarica == null) {
			if (other.taglioRicarica != null)
				return false;
		} else if (!taglioRicarica.equals(other.taglioRicarica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaglioRicaricaOutputBean [taglioRicarica=" + taglioRicarica + "]";
	}

	
    
}
