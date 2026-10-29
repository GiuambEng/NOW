package com.nttdata.tim.now.data.bean.ordine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecuperaProfiliFwaOutputBean {

    @JsonProperty("descrizioneProfilo")
    private String descrizioneProfilo;
    
    @JsonProperty("velocitaDown")
    private String velocitaDown;
    
    @JsonProperty("velocitaUp")
    private String velocitaUp;
    
    @JsonProperty("profilo")
    private String profilo;
    
    //RU_1129
    @JsonProperty("tipologiaCPE")
    private String tipologiaCPE;

	public String getDescrizioneProfilo() {
		return descrizioneProfilo;
	}

	public void setDescrizioneProfilo(String descrizioneProfilo) {
		this.descrizioneProfilo = descrizioneProfilo;
	}

	public String getVelocitaDown() {
		return velocitaDown;
	}

	public void setVelocitaDown(String velocitaDown) {
		this.velocitaDown = velocitaDown;
	}

	public String getVelocitaUp() {
		return velocitaUp;
	}

	public void setVelocitaUp(String velocitaUp) {
		this.velocitaUp = velocitaUp;
	}

	public String getProfilo() {
		return profilo;
	}

	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}

	public String getTipologiaCPE() {
		return tipologiaCPE;
	}

	public void setTipologiaCPE(String tipologiaCPE) {
		this.tipologiaCPE = tipologiaCPE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizioneProfilo == null) ? 0 : descrizioneProfilo.hashCode());
		result = prime * result + ((profilo == null) ? 0 : profilo.hashCode());
		result = prime * result + ((tipologiaCPE == null) ? 0 : tipologiaCPE.hashCode());
		result = prime * result + ((velocitaDown == null) ? 0 : velocitaDown.hashCode());
		result = prime * result + ((velocitaUp == null) ? 0 : velocitaUp.hashCode());
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
		RecuperaProfiliFwaOutputBean other = (RecuperaProfiliFwaOutputBean) obj;
		if (descrizioneProfilo == null) {
			if (other.descrizioneProfilo != null)
				return false;
		} else if (!descrizioneProfilo.equals(other.descrizioneProfilo))
			return false;
		if (profilo == null) {
			if (other.profilo != null)
				return false;
		} else if (!profilo.equals(other.profilo))
			return false;
		if (tipologiaCPE == null) {
			if (other.tipologiaCPE != null)
				return false;
		} else if (!tipologiaCPE.equals(other.tipologiaCPE))
			return false;
		if (velocitaDown == null) {
			if (other.velocitaDown != null)
				return false;
		} else if (!velocitaDown.equals(other.velocitaDown))
			return false;
		if (velocitaUp == null) {
			if (other.velocitaUp != null)
				return false;
		} else if (!velocitaUp.equals(other.velocitaUp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaProfiliFwaOutputBean [descrizioneProfilo=" + descrizioneProfilo + ", velocitaDown="
				+ velocitaDown + ", velocitaUp=" + velocitaUp + ", profilo=" + profilo + ", tipologiaCPE="
				+ tipologiaCPE + "]";
	}
    
    
}
