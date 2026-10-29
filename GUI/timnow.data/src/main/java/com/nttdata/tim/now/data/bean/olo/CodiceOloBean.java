package com.nttdata.tim.now.data.bean.olo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class CodiceOloBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 6703275975291167563L;

	@JsonProperty("codiceOloAgcom")
	private String codiceOloAgcom;

	@JsonProperty("codiceOloNow")
	private String codiceOloNow;

	public String getCodiceOloAgcom() {
		return codiceOloAgcom;
	}

	public void setCodiceOloAgcom(String codiceOloAgcom) {
		this.codiceOloAgcom = codiceOloAgcom;
	}

	public String getCodiceOloNow() {
		return codiceOloNow;
	}

	public void setCodiceOloNow(String codiceOloNow) {
		this.codiceOloNow = codiceOloNow;
	}

	@Override
	public String toString() {
		return "CodiceOloBean [codiceOloAgcom=" + codiceOloAgcom + ", codiceOloNow=" + codiceOloNow + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOloAgcom == null) ? 0 : codiceOloAgcom.hashCode());
		result = prime * result + ((codiceOloNow == null) ? 0 : codiceOloNow.hashCode());
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
		CodiceOloBean other = (CodiceOloBean) obj;
		if (codiceOloAgcom == null) {
			if (other.codiceOloAgcom != null)
				return false;
		} else if (!codiceOloAgcom.equals(other.codiceOloAgcom))
			return false;
		if (codiceOloNow == null) {
			if (other.codiceOloNow != null)
				return false;
		} else if (!codiceOloNow.equals(other.codiceOloNow))
			return false;
		return true;
	}

}