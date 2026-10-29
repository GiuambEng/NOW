package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class VerificaTecnologiaOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -9069775023481774435L;

	@JsonProperty("tecnologia")
	private String tecnologia;

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tecnologia == null) ? 0 : tecnologia.hashCode());
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
		VerificaTecnologiaOutputBean other = (VerificaTecnologiaOutputBean) obj;
		if (tecnologia == null) {
			if (other.tecnologia != null)
				return false;
		} else if (!tecnologia.equals(other.tecnologia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaTecnologiaOutputBean [tecnologia=" + tecnologia + "]";
	}

	
}
