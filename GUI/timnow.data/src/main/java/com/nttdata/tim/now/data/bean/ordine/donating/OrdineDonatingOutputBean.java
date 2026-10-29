package com.nttdata.tim.now.data.bean.ordine.donating;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDonatingOutputBean implements Serializable{

	private static final long serialVersionUID = -8710791346126528823L;

	@JsonProperty("ordineTI")
	private String ordineTI;

	@JsonProperty("statoOAO")
	private String statoOAO;

	@JsonProperty("oaoDonating")
	private String oaoDonating;

	@JsonProperty("idRichiestaOLO")
	private String idRichiestaOLO;

	@JsonProperty("oao")
	private String oao;
	
	@JsonProperty("codiceOrdineOao")
	private String codiceOrdineOao;

	@JsonProperty("statoNow")
	private String statoNow;
	
	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("flagDiffidato")
	private String flagDiffidato;

	@JsonProperty("ambitoServizioRecipient")
	private String ambitoServizioRecipient;
	
	@JsonProperty("ambitoServizioDonating")
	private String ambitoServizioDonating;

	public String getOrdineTI() {
		return ordineTI;
	}

	public void setOrdineTI(String ordineTI) {
		this.ordineTI = ordineTI;
	}

	public String getStatoOAO() {
		return statoOAO;
	}

	public void setStatoOAO(String statoOAO) {
		this.statoOAO = statoOAO;
	}

	public String getOaoDonating() {
		return oaoDonating;
	}

	public void setOaoDonating(String oaoDonating) {
		this.oaoDonating = oaoDonating;
	}

	public String getIdRichiestaOLO() {
		return idRichiestaOLO;
	}

	public void setIdRichiestaOLO(String idRichiestaOLO) {
		this.idRichiestaOLO = idRichiestaOLO;
	}

	public String getOao() {
		return oao;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public String getCodiceOrdineOao() {
		return codiceOrdineOao;
	}

	public void setCodiceOrdineOao(String codiceOrdineOao) {
		this.codiceOrdineOao = codiceOrdineOao;
	}

	public String getStatoNow() {
		return statoNow;
	}

	public void setStatoNow(String statoNow) {
		this.statoNow = statoNow;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getFlagDiffidato() {
		return flagDiffidato;
	}

	public void setFlagDiffidato(String flagDiffidato) {
		this.flagDiffidato = flagDiffidato;
	}

	public String getAmbitoServizioRecipient() {
		return ambitoServizioRecipient;
	}

	public void setAmbitoServizioRecipient(String ambitoServizioRecipient) {
		this.ambitoServizioRecipient = ambitoServizioRecipient;
	}

	public String getAmbitoServizioDonating() {
		return ambitoServizioDonating;
	}

	public void setAmbitoServizioDonating(String ambitoServizioDonating) {
		this.ambitoServizioDonating = ambitoServizioDonating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambitoServizioDonating == null) ? 0 : ambitoServizioDonating.hashCode());
		result = prime * result + ((ambitoServizioRecipient == null) ? 0 : ambitoServizioRecipient.hashCode());
		result = prime * result + ((codiceOrdineOao == null) ? 0 : codiceOrdineOao.hashCode());
		result = prime * result + ((flagDiffidato == null) ? 0 : flagDiffidato.hashCode());
		result = prime * result + ((idRichiestaOLO == null) ? 0 : idRichiestaOLO.hashCode());
		result = prime * result + ((oao == null) ? 0 : oao.hashCode());
		result = prime * result + ((oaoDonating == null) ? 0 : oaoDonating.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((ordineTI == null) ? 0 : ordineTI.hashCode());
		result = prime * result + ((statoNow == null) ? 0 : statoNow.hashCode());
		result = prime * result + ((statoOAO == null) ? 0 : statoOAO.hashCode());
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
		OrdineDonatingOutputBean other = (OrdineDonatingOutputBean) obj;
		if (ambitoServizioDonating == null) {
			if (other.ambitoServizioDonating != null)
				return false;
		} else if (!ambitoServizioDonating.equals(other.ambitoServizioDonating))
			return false;
		if (ambitoServizioRecipient == null) {
			if (other.ambitoServizioRecipient != null)
				return false;
		} else if (!ambitoServizioRecipient.equals(other.ambitoServizioRecipient))
			return false;
		if (codiceOrdineOao == null) {
			if (other.codiceOrdineOao != null)
				return false;
		} else if (!codiceOrdineOao.equals(other.codiceOrdineOao))
			return false;
		if (flagDiffidato == null) {
			if (other.flagDiffidato != null)
				return false;
		} else if (!flagDiffidato.equals(other.flagDiffidato))
			return false;
		if (idRichiestaOLO == null) {
			if (other.idRichiestaOLO != null)
				return false;
		} else if (!idRichiestaOLO.equals(other.idRichiestaOLO))
			return false;
		if (oao == null) {
			if (other.oao != null)
				return false;
		} else if (!oao.equals(other.oao))
			return false;
		if (oaoDonating == null) {
			if (other.oaoDonating != null)
				return false;
		} else if (!oaoDonating.equals(other.oaoDonating))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (ordineTI == null) {
			if (other.ordineTI != null)
				return false;
		} else if (!ordineTI.equals(other.ordineTI))
			return false;
		if (statoNow == null) {
			if (other.statoNow != null)
				return false;
		} else if (!statoNow.equals(other.statoNow))
			return false;
		if (statoOAO == null) {
			if (other.statoOAO != null)
				return false;
		} else if (!statoOAO.equals(other.statoOAO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineDonatingOutputBean [ordineTI=" + ordineTI + ", statoOAO=" + statoOAO + ", oaoDonating="
				+ oaoDonating + ", idRichiestaOLO=" + idRichiestaOLO + ", oao=" + oao + ", codiceOrdineOao="
				+ codiceOrdineOao + ", statoNow=" + statoNow + ", offerta=" + offerta + ", flagDiffidato="
				+ flagDiffidato + ", ambitoServizioRecipient=" + ambitoServizioRecipient + ", ambitoServizioDonating="
				+ ambitoServizioDonating + "]";
	}



}
