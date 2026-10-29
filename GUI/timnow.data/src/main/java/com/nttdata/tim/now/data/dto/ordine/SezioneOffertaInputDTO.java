package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SezioneOffertaInputDTO implements Serializable {

	private static final long serialVersionUID = 8744266238300978836L;

	@JsonProperty("key")
    private String key;

    @JsonProperty("componente")
    private String componente;

    @JsonProperty("tipologiaDato")
    private String tipologiaDato;

    @JsonProperty("valore")
    private String dft;

    @JsonProperty("progressivo")
    private String progressivo;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public String getTipologiaDato() {
		return tipologiaDato;
	}

	public void setTipologiaDato(String tipologiaDato) {
		this.tipologiaDato = tipologiaDato;
	}

	public String getDft() {
		return dft;
	}

	public void setDft(String dft) {
		this.dft = dft;
	}

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componente == null) ? 0 : componente.hashCode());
		result = prime * result + ((dft == null) ? 0 : dft.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((progressivo == null) ? 0 : progressivo.hashCode());
		result = prime * result + ((tipologiaDato == null) ? 0 : tipologiaDato.hashCode());
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
		SezioneOffertaInputDTO other = (SezioneOffertaInputDTO) obj;
		if (componente == null) {
			if (other.componente != null)
				return false;
		} else if (!componente.equals(other.componente))
			return false;
		if (dft == null) {
			if (other.dft != null)
				return false;
		} else if (!dft.equals(other.dft))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		if (tipologiaDato == null) {
			if (other.tipologiaDato != null)
				return false;
		} else if (!tipologiaDato.equals(other.tipologiaDato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SezioneOffertaInputDTO [key=" + key + ", componente=" + componente + ", tipologiaDato=" + tipologiaDato
				+ ", dft=" + dft + ", progressivo=" + progressivo + "]";
	}
    
}
