package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class CodiceUnivocoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -7906807456225652443L;

	@JsonProperty("codiceUnivoco")
    private String codiceUnivoco;

	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceUnivoco == null) ? 0 : codiceUnivoco.hashCode());
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
		CodiceUnivocoOutputBean other = (CodiceUnivocoOutputBean) obj;
		if (codiceUnivoco == null) {
			if (other.codiceUnivoco != null)
				return false;
		} else if (!codiceUnivoco.equals(other.codiceUnivoco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodiceUnivocoOutputBean [codiceUnivoco=" + codiceUnivoco + "]";
	}

	

}