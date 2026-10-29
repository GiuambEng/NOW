package com.nttdata.tim.now.data.dto.offerta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class DisambiguazioneOffertaDTO implements Serializable {

	private static final long serialVersionUID = -8234729378404329778L;

	@JsonProperty("offerta")
	private String offerta;

    @JsonProperty("nomeOfferta")
    private String nomeOfferta;
    
    @JsonProperty("idOfferta")
    private String idOfferta;

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getNomeOfferta() {
		return nomeOfferta;
	}

	public void setNomeOfferta(String nomeOfferta) {
		this.nomeOfferta = nomeOfferta;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((nomeOfferta == null) ? 0 : nomeOfferta.hashCode());
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
		DisambiguazioneOffertaDTO other = (DisambiguazioneOffertaDTO) obj;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (nomeOfferta == null) {
			if (other.nomeOfferta != null)
				return false;
		} else if (!nomeOfferta.equals(other.nomeOfferta))
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
		return "DisambiguazioneOffertaDTO [offerta=" + offerta + ", nomeOfferta=" + nomeOfferta + ", idOfferta="
				+ idOfferta + "]";
	}
    
}
