package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class VerificaCoppiaBandePiccoBandaInputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 790577743777020949L;

	@JsonProperty("up")
    private String bandaPiccoUP;

	@JsonProperty("down")
    private String bandaPiccoDOWN;
	
	@JsonProperty("userVlanId")
    private String userVlanId;

	public String getBandaPiccoUP() {
		return bandaPiccoUP;
	}

	public void setBandaPiccoUP(String bandaPiccoUP) {
		this.bandaPiccoUP = bandaPiccoUP;
	}

	public String getBandaPiccoDOWN() {
		return bandaPiccoDOWN;
	}

	public void setBandaPiccoDOWN(String bandaPiccoDOWN) {
		this.bandaPiccoDOWN = bandaPiccoDOWN;
	}

	public String getUserVlanId() {
		return userVlanId;
	}

	public void setUserVlanId(String userVlanId) {
		this.userVlanId = userVlanId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bandaPiccoDOWN == null) ? 0 : bandaPiccoDOWN.hashCode());
		result = prime * result + ((bandaPiccoUP == null) ? 0 : bandaPiccoUP.hashCode());
		result = prime * result + ((userVlanId == null) ? 0 : userVlanId.hashCode());
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
		VerificaCoppiaBandePiccoBandaInputBean other = (VerificaCoppiaBandePiccoBandaInputBean) obj;
		if (bandaPiccoDOWN == null) {
			if (other.bandaPiccoDOWN != null)
				return false;
		} else if (!bandaPiccoDOWN.equals(other.bandaPiccoDOWN))
			return false;
		if (bandaPiccoUP == null) {
			if (other.bandaPiccoUP != null)
				return false;
		} else if (!bandaPiccoUP.equals(other.bandaPiccoUP))
			return false;
		if (userVlanId == null) {
			if (other.userVlanId != null)
				return false;
		} else if (!userVlanId.equals(other.userVlanId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCoppiaBandePiccoBandaInputBean [bandaPiccoUP=" + bandaPiccoUP + ", bandaPiccoDOWN="
				+ bandaPiccoDOWN + ", userVlanId=" + userVlanId + "]";
	}

}