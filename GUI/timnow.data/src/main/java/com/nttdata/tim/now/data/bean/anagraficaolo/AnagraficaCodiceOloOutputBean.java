package com.nttdata.tim.now.data.bean.anagraficaolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class AnagraficaCodiceOloOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 3025940809476551959L;

	@JsonProperty("codOloNumerico")
	private String codOloNumerico;

	public String getCodOloNumerico() {
		return codOloNumerico;
	}

	public void setCodOloNumerico(String codOloNumerico) {
		this.codOloNumerico = codOloNumerico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloNumerico == null) ? 0 : codOloNumerico.hashCode());
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
		AnagraficaCodiceOloOutputBean other = (AnagraficaCodiceOloOutputBean) obj;
		if (codOloNumerico == null) {
			if (other.codOloNumerico != null)
				return false;
		} else if (!codOloNumerico.equals(other.codOloNumerico))
			return false;
		return true;
	}
	
	
}
