package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL) 
public class RecuperoDatiContrattoOutputDTO extends ESBResultDTO implements Serializable{
	
	private static final long serialVersionUID = 4700255121456518166L;

	@JsonProperty("tipoServizio")
	private List<String> tipoServizio;
	
	@JsonProperty("idFamigliaOfferta")
	private List<String> idFamigliaOfferta;
	
	@JsonProperty("tipoProdotti")
	private List<String> tipoProdotti;
	
	@JsonProperty("idSottofamigliaOfferta")
	private List<String> idSottofamigliaOfferta;
	
	@JsonProperty("offerta")
	private List<String> offerta;
	
	@JsonProperty("idOfferta")
	private List<String> idOfferta;

	public List<String> getTipoServizio() {
		return tipoServizio;
	}

	public void setTipoServizio(List<String> tipoServizio) {
		this.tipoServizio = tipoServizio;
	}

	public List<String> getIdFamigliaOfferta() {
		return idFamigliaOfferta;
	}

	public void setIdFamigliaOfferta(List<String> idFamigliaOfferta) {
		this.idFamigliaOfferta = idFamigliaOfferta;
	}

	public List<String> getTipoProdotti() {
		return tipoProdotti;
	}

	public void setTipoProdotti(List<String> tipoProdotti) {
		this.tipoProdotti = tipoProdotti;
	}

	public List<String> getIdSottofamigliaOfferta() {
		return idSottofamigliaOfferta;
	}

	public void setIdSottofamigliaOfferta(List<String> idSottofamigliaOfferta) {
		this.idSottofamigliaOfferta = idSottofamigliaOfferta;
	}

	public List<String> getOfferta() {
		return offerta;
	}

	public void setOfferta(List<String> offerta) {
		this.offerta = offerta;
	}

	public List<String> getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(List<String> idOfferta) {
		this.idOfferta = idOfferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFamigliaOfferta == null) ? 0 : idFamigliaOfferta.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idSottofamigliaOfferta == null) ? 0 : idSottofamigliaOfferta.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((tipoProdotti == null) ? 0 : tipoProdotti.hashCode());
		result = prime * result + ((tipoServizio == null) ? 0 : tipoServizio.hashCode());
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
		RecuperoDatiContrattoOutputDTO other = (RecuperoDatiContrattoOutputDTO) obj;
		if (idFamigliaOfferta == null) {
			if (other.idFamigliaOfferta != null)
				return false;
		} else if (!idFamigliaOfferta.equals(other.idFamigliaOfferta))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idSottofamigliaOfferta == null) {
			if (other.idSottofamigliaOfferta != null)
				return false;
		} else if (!idSottofamigliaOfferta.equals(other.idSottofamigliaOfferta))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (tipoProdotti == null) {
			if (other.tipoProdotti != null)
				return false;
		} else if (!tipoProdotti.equals(other.tipoProdotti))
			return false;
		if (tipoServizio == null) {
			if (other.tipoServizio != null)
				return false;
		} else if (!tipoServizio.equals(other.tipoServizio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperoDatiContrattoOutputDTO [tipoServizio=" + tipoServizio + ", idFamigliaOfferta="
				+ idFamigliaOfferta + ", tipoProdotti=" + tipoProdotti + ", idSottofamigliaOfferta="
				+ idSottofamigliaOfferta + ", offerta=" + offerta + ", idOfferta=" + idOfferta + "]";
	}
	
}
