package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class CheckNumMaxVCConfigurabiliOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 3975515109306525901L;

	@JsonProperty("numMaxVCxCF")
    private String numMaxVCxCF;

	public String getNumMaxVCxCF() {
		return numMaxVCxCF;
	}

	public void setNumMaxVCxCF(String numMaxVCxCF) {
		this.numMaxVCxCF = numMaxVCxCF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numMaxVCxCF == null) ? 0 : numMaxVCxCF.hashCode());
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
		CheckNumMaxVCConfigurabiliOutputBean other = (CheckNumMaxVCConfigurabiliOutputBean) obj;
		if (numMaxVCxCF == null) {
			if (other.numMaxVCxCF != null)
				return false;
		} else if (!numMaxVCxCF.equals(other.numMaxVCxCF))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckNumMaxVCConfigurabiliOutputBean [numMaxVCxCF=" + numMaxVCxCF + "]";
	}

	
}
