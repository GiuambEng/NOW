package com.nttdata.tim.now.data.dto.vc;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ProfiloVcOutputDTO implements Serializable {

	private static final long serialVersionUID = -6772262686789253739L;

	@JsonProperty("identificativoProfiloVc")
	private String identificativoProfiloVc;

	@JsonProperty("profilo")
	private String profilo;

	@JsonProperty("tipoProfilo")
	private String tipoProfilo;

	@JsonProperty("mcr_Down")
	private String mcrDown;

	@JsonProperty("mcr_Up")
	private String mcrUp;

	@JsonProperty("pcr_Down")
	private String pcrDown;

	@JsonProperty("pcr_Up")
	private String pcrUp;

	@JsonProperty("scr_Down")
	private String scrDown;

	@JsonProperty("scr_Up")
	private String scrUp;

	@JsonProperty("identificativoOfferta")
	private String identificativoOfferta;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("flagVendibilita")
	private String flagVendibilita;

	public String getIdentificativoProfiloVc() {
		return identificativoProfiloVc;
	}

	public void setIdentificativoProfiloVc(String identificativoProfiloVc) {
		this.identificativoProfiloVc = identificativoProfiloVc;
	}

	public String getProfilo() {
		return profilo;
	}

	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}

	public String getTipoProfilo() {
		return tipoProfilo;
	}

	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	public String getMcrDown() {
		return mcrDown;
	}

	public void setMcrDown(String mcrDown) {
		this.mcrDown = mcrDown;
	}

	public String getMcrUp() {
		return mcrUp;
	}

	public void setMcrUp(String mcrUp) {
		this.mcrUp = mcrUp;
	}

	public String getPcrDown() {
		return pcrDown;
	}

	public void setPcrDown(String pcrDown) {
		this.pcrDown = pcrDown;
	}

	public String getPcrUp() {
		return pcrUp;
	}

	public void setPcrUp(String pcrUp) {
		this.pcrUp = pcrUp;
	}

	public String getScrDown() {
		return scrDown;
	}

	public void setScrDown(String scrDown) {
		this.scrDown = scrDown;
	}

	public String getScrUp() {
		return scrUp;
	}

	public void setScrUp(String scrUp) {
		this.scrUp = scrUp;
	}

	public String getIdentificativoOfferta() {
		return identificativoOfferta;
	}

	public void setIdentificativoOfferta(String identificativoOfferta) {
		this.identificativoOfferta = identificativoOfferta;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getFlagVendibilita() {
		return flagVendibilita;
	}

	public void setFlagVendibilita(String flagVendibilita) {
		this.flagVendibilita = flagVendibilita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flagVendibilita == null) ? 0 : flagVendibilita.hashCode());
		result = prime * result + ((identificativoOfferta == null) ? 0 : identificativoOfferta.hashCode());
		result = prime * result + ((identificativoProfiloVc == null) ? 0 : identificativoProfiloVc.hashCode());
		result = prime * result + ((mcrDown == null) ? 0 : mcrDown.hashCode());
		result = prime * result + ((mcrUp == null) ? 0 : mcrUp.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((pcrDown == null) ? 0 : pcrDown.hashCode());
		result = prime * result + ((pcrUp == null) ? 0 : pcrUp.hashCode());
		result = prime * result + ((profilo == null) ? 0 : profilo.hashCode());
		result = prime * result + ((scrDown == null) ? 0 : scrDown.hashCode());
		result = prime * result + ((scrUp == null) ? 0 : scrUp.hashCode());
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
		ProfiloVcOutputDTO other = (ProfiloVcOutputDTO) obj;
		if (flagVendibilita == null) {
			if (other.flagVendibilita != null)
				return false;
		} else if (!flagVendibilita.equals(other.flagVendibilita))
			return false;
		if (identificativoOfferta == null) {
			if (other.identificativoOfferta != null)
				return false;
		} else if (!identificativoOfferta.equals(other.identificativoOfferta))
			return false;
		if (identificativoProfiloVc == null) {
			if (other.identificativoProfiloVc != null)
				return false;
		} else if (!identificativoProfiloVc.equals(other.identificativoProfiloVc))
			return false;
		if (mcrDown == null) {
			if (other.mcrDown != null)
				return false;
		} else if (!mcrDown.equals(other.mcrDown))
			return false;
		if (mcrUp == null) {
			if (other.mcrUp != null)
				return false;
		} else if (!mcrUp.equals(other.mcrUp))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (pcrDown == null) {
			if (other.pcrDown != null)
				return false;
		} else if (!pcrDown.equals(other.pcrDown))
			return false;
		if (pcrUp == null) {
			if (other.pcrUp != null)
				return false;
		} else if (!pcrUp.equals(other.pcrUp))
			return false;
		if (profilo == null) {
			if (other.profilo != null)
				return false;
		} else if (!profilo.equals(other.profilo))
			return false;
		if (scrDown == null) {
			if (other.scrDown != null)
				return false;
		} else if (!scrDown.equals(other.scrDown))
			return false;
		if (scrUp == null) {
			if (other.scrUp != null)
				return false;
		} else if (!scrUp.equals(other.scrUp))
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
		return "ProfiloVcOutputDTO [identificativoProfiloVc=" + identificativoProfiloVc + ", profilo=" + profilo
				+ ", tipoProfilo=" + tipoProfilo + ", mcrDown=" + mcrDown + ", mcrUp=" + mcrUp + ", pcrDown=" + pcrDown
				+ ", pcrUp=" + pcrUp + ", scrDown=" + scrDown + ", scrUp=" + scrUp + ", identificativoOfferta="
				+ identificativoOfferta + ", offerta=" + offerta + ", flagVendibilita=" + flagVendibilita + "]";
	}

}
