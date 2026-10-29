package com.nttdata.tim.now.data.dto.ordine.richiesta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecuperaRichiesteOutputDTO implements Serializable {

	private static final long serialVersionUID = -5900767131636825742L;

	@JsonProperty("richiesta")
	private String richiesta;
	
	@JsonProperty("richiestaLabel")
	private String richiestaLabel;

	public String getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(String richiesta) {
		this.richiesta = richiesta;
	}

	public String getRichiestaLabel() {
		return richiestaLabel;
	}

	public void setRichiestaLabel(String richiestaLabel) {
		this.richiestaLabel = richiestaLabel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((richiesta == null) ? 0 : richiesta.hashCode());
		result = prime * result + ((richiestaLabel == null) ? 0 : richiestaLabel.hashCode());
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
		RecuperaRichiesteOutputDTO other = (RecuperaRichiesteOutputDTO) obj;
		if (richiesta == null) {
			if (other.richiesta != null)
				return false;
		} else if (!richiesta.equals(other.richiesta))
			return false;
		if (richiestaLabel == null) {
			if (other.richiestaLabel != null)
				return false;
		} else if (!richiestaLabel.equals(other.richiestaLabel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaRichiesteOutputDTO [richiesta=" + richiesta + ", richiestaLabel=" + richiestaLabel + "]";
	}
	
	

}
