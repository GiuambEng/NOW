package com.nttdata.tim.now.data.dto.ordine.donating;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDonatingInputDTO implements Serializable {
	
	private static final long serialVersionUID = 4096417309806927084L;

	@JsonProperty("tipoProfilo")
	private String tipoProfilo;

	@JsonProperty("codificaAgcom")
	private String codificaAgcom;

	@JsonProperty("codOrdineTI")
	private String codiceOrdineTI;

	@JsonProperty("nomeFileNotifica")
	private String nomeFileNotifica;

	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("codiceSessione")
	private String codiceSessione;

	public String getTipoProfilo() {
		return tipoProfilo;
	}

	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	public String getCodificaAgcom() {
		return codificaAgcom;
	}

	public void setCodificaAgcom(String codificaAgcom) {
		this.codificaAgcom = codificaAgcom;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public String getNomeFileNotifica() {
		return nomeFileNotifica;
	}

	public void setNomeFileNotifica(String nomeFileNotifica) {
		this.nomeFileNotifica = nomeFileNotifica;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getCodiceSessione() {
		return codiceSessione;
	}

	public void setCodiceSessione(String codiceSessione) {
		this.codiceSessione = codiceSessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
		result = prime * result + ((codiceSessione == null) ? 0 : codiceSessione.hashCode());
		result = prime * result + ((codificaAgcom == null) ? 0 : codificaAgcom.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((nomeFileNotifica == null) ? 0 : nomeFileNotifica.hashCode());
		result = prime * result + ((tipoProfilo == null) ? 0 : tipoProfilo.hashCode());
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
		OrdineDonatingInputDTO other = (OrdineDonatingInputDTO) obj;
		if (codiceOrdineTI == null) {
			if (other.codiceOrdineTI != null)
				return false;
		} else if (!codiceOrdineTI.equals(other.codiceOrdineTI))
			return false;
		if (codiceSessione == null) {
			if (other.codiceSessione != null)
				return false;
		} else if (!codiceSessione.equals(other.codiceSessione))
			return false;
		if (codificaAgcom == null) {
			if (other.codificaAgcom != null)
				return false;
		} else if (!codificaAgcom.equals(other.codificaAgcom))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (nomeFileNotifica == null) {
			if (other.nomeFileNotifica != null)
				return false;
		} else if (!nomeFileNotifica.equals(other.nomeFileNotifica))
			return false;
		if (tipoProfilo == null) {
			if (other.tipoProfilo != null)
				return false;
		} else if (!tipoProfilo.equals(other.tipoProfilo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineDonatingInputDTO [tipoProfilo=" + tipoProfilo + ", codificaAgcom=" + codificaAgcom
				+ ", codiceOrdineTI=" + codiceOrdineTI + ", nomeFileNotifica=" + nomeFileNotifica + ", idRisorsa="
				+ idRisorsa + ", codiceSessione=" + codiceSessione + "]";
	}


}
